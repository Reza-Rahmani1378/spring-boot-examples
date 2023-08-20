package com.hami.sqlspringboot.sql.service.mapper;

import com.hami.sqlspringboot.sql.dal.entity.User;
import com.hami.sqlspringboot.sql.service.model.UserCountGroupModel;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import com.hami.sqlspringboot.sql.service.model.UserCountOutputModel;
import com.hami.sqlspringboot.sql.service.model.UserPodamModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {
    User getEntityFromUserPodamModel(UserPodamModel model);

    default UserCountOutputModel getReportUserOutputModelFromModel(List<UserCountGroupModel> userCountGroupModel) {
        UserCountOutputModel reportUserOutputModel = new UserCountOutputModel(0L,0L,0L);
        if (userCountGroupModel.size() == 0) {
            return reportUserOutputModel;
        }
        userCountGroupModel.forEach(
                model -> {
                    if (model.getIsLocked()) {
                        reportUserOutputModel.setCountLocked(model.getCountUser());
                    } else {
                        reportUserOutputModel.setCountUnlocked(model.getCountUser());
                    }
                    reportUserOutputModel.setTotalCount(
                            reportUserOutputModel.getCountLocked() + reportUserOutputModel.getCountUnlocked()
                    );
                }
        );

        return reportUserOutputModel;
    }
}
