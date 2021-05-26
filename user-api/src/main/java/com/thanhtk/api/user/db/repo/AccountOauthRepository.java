package com.thanhtk.api.user.db.repo;

import com.thanhtk.api.user.db.entity.AccountOauthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOauthRepository extends JpaRepository<AccountOauthEntity, String> {

}
