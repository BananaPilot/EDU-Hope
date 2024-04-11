package com.teamproject1.scuoledevelhope.framework;

import com.bananapilot.samplespringauthenticationframework.utils.FloorLevelImpl;
import com.teamproject1.scuoledevelhope.types.errors.NullValueException;
import org.springframework.stereotype.Component;


@Component
public class FloorLeveImplInternal extends FloorLevelImpl {

    @Override
    protected boolean isRoleInternalGreaterOrEquals(String requiredRole, String userRoles) {
        return switch (requiredRole) {
            case "STUDENT" -> "USER".equals(userRoles) || "MODERATOR".equals(userRoles) || "ADMIN".equals(userRoles) || "SUPER-ADMIN".equals(userRoles) || "TUTOR".equals(userRoles) || "COORDINATOR".equals(userRoles);
            case "TUTOR" -> "ADMIN".equals(userRoles) || "SUPER-ADMIN".equals(userRoles) || "COORDINATOR".equals(userRoles);
            case "COORDINATOR", "ADMIN" -> "ADMIN".equals(userRoles) || "SUPER-ADMIN".equals(userRoles);
            case "USER" ->
                    "USER".equals(userRoles) || "MODERATOR".equals(userRoles) || "ADMIN".equals(userRoles) || "SUPER-ADMIN".equals(userRoles);
            case "MODERATOR" ->
                    "MODERATOR".equals(userRoles) || "ADMIN".equals(userRoles) || "SUPER-ADMIN".equals(userRoles);
            case "SUPER-ADMIN" -> "SUPER-ADMIN".equals(userRoles);
            case null -> throw new NullValueException("role can't be null on this endpoint");
            default -> false;
        };
    }

}
