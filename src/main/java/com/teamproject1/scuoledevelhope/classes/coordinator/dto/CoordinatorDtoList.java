package com.teamproject1.scuoledevelhope.classes.coordinator.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CoordinatorDtoList extends Pagination {

    private List<CoordinatorDto> coordinators;

    public CoordinatorDtoList() {
    }

    public List<CoordinatorDto> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(List<CoordinatorDto> coordinators) {
        this.coordinators = coordinators;
    }


    public static final class CoordinatorDtoListBuilder {
        private List<CoordinatorDto> coordinators;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;

        private CoordinatorDtoListBuilder() {
        }

        public static CoordinatorDtoListBuilder aCoordinatorDtoList() {
            return new CoordinatorDtoListBuilder();
        }

        public CoordinatorDtoListBuilder withCoordinators(List<CoordinatorDto> coordinators) {
            this.coordinators = coordinators;
            return this;
        }

        public CoordinatorDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public CoordinatorDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public CoordinatorDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public CoordinatorDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public CoordinatorDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public CoordinatorDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public CoordinatorDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CoordinatorDtoList build() {
            CoordinatorDtoList coordinatorDtoList = new CoordinatorDtoList();
            coordinatorDtoList.setCoordinators(coordinators);
            coordinatorDtoList.setPage(page);
            coordinatorDtoList.setPageSize(pageSize);
            coordinatorDtoList.setTotalElements(totalElements);
            coordinatorDtoList.setTotalPages(totalPages);
            coordinatorDtoList.setHttpStatus(httpStatus);
            coordinatorDtoList.setMessage(message);
            coordinatorDtoList.setDescription(description);
            return coordinatorDtoList;
        }
    }
}
