package com.teamproject1.scuoledevelhope.classes.classP.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {
    private final ClassDAO classDAO;
    private final RegisterDao registerDao;
    private final ClassRegisterMapper classRegisterMapper;
    private final TutorDAO tutorDAO;
    private final StudentDAO studentDAO;
    private final CoordinatorDAO coordinatorDAO;
    private final Utils utils;

    public ClassService(ClassDAO classDAO, RegisterDao registerDao, ClassRegisterMapper classRegisterMapper,
                        TutorDAO tutorDAO, StudentDAO studentDAO, CoordinatorDAO coordinatorDAO, Utils utils) {
        this.classDAO = classDAO;
        this.registerDao = registerDao;
        this.classRegisterMapper = classRegisterMapper;
        this.tutorDAO = tutorDAO;
        this.studentDAO = studentDAO;
        this.coordinatorDAO = coordinatorDAO;
        this.utils = utils;
    }

    public ClassRegisterDtoList findAll(int limit, int page) {
        Page<Classes> classes = classDAO.findAll(PageRequest.of(page, limit));
        return ClassRegisterDtoList.ClassRegisterDtoListBuilder.aClassRegisterDtoList()
                .withClasses(classRegisterMapper.toListOfClassRegisterDto(classes.toList()))
                .withPage(classes.getPageable().getPageNumber())
                .withTotalElements(classes.getTotalElements())
                .withPageSize(classes.getPageable().getPageSize())
                .withTotalPages(classes.getTotalPages())
                .build();
    }

    public BaseResponseElement<ClassRegisterDTO> findById(Long id) {
        Optional<Classes> result = classDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(classRegisterMapper.toClassRegisterDTO(result.get()));
    }

    public BaseResponseElement<ClassRegisterDTO> save(ClassRegisterDTO classDTO) {
        Classes classes = classRegisterMapper.toClass(classDTO);
        Register register = classRegisterMapper.toRegister(classDTO);

        classDAO.save(classes);

        register.setSchoolClass(classDAO.findById(classes.getId()).orElseThrow(
                () -> new NotFoundException("class not found")
        ));

        registerDao.save(register);

        return new BaseResponseElement<>(classDTO);
    }

    @Transactional
    public BaseResponseElement<ClassRegisterDTO> deleteById(Long id) {
        Optional<Classes> classes = classDAO.findById(id);
        Optional<Register> register = registerDao.findById(id);

        if (classes.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        if (register.isEmpty()) {
            throw new SQLException("Register was not present");
        }
        ClassRegisterDTO temp = classRegisterMapper.toClassRegisterDTO(classes.get());

        registerDao.deleteById(id);
        classDAO.deleteById(id);

        return new BaseResponseElement<>(temp);
    }

    @Transactional
    public BaseResponseElement<ClassRegisterDTO> addClassToUser(Long userId, Long classId) {
        Tutor tutor = utils.isPresent(tutorDAO.findById(userId));
        Coordinator coordinator = utils.isPresent(coordinatorDAO.findById(userId));
        Student student = utils.isPresent(studentDAO.findById(userId));
        Classes classes = utils.isPresent(classDAO.findById(classId));

        if (student != null && student.getSchoolClass() == null) {
            studentDAO.updateStudentClass(student.getId(), classId);
            student.setSchoolClass(classes);
        }
        if (coordinator != null && classes.getCoordinator() == null) {
            classDAO.updateClassCoordinator(classId, coordinator.getUser().getId());
            classes.setCoordinator(coordinator);
        }
        if (tutor != null && classes.getTutor() == null) {
            classDAO.updateClassTutor(classId, tutor.getUser().getId());
            classes.setTutor(tutor);
        }

        return new BaseResponseElement<>(classRegisterMapper.toClassRegisterDTO(classes));
    }
}
