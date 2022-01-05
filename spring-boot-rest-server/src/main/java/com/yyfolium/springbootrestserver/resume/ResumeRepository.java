package com.yyfolium.springbootrestserver.resume;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
    import com.yyfolium.springbootrestserver.user.User;

    import java.util.List;

public interface ResumeRepository extends GenericRepositoryJoinUser<Resume> {
    List<Resume> findByUserAndHistoryFlagOrderByStartDate(User user, Integer historyFlag);
}
