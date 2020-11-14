/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.repositories;

import bootcamp37.mbc.entities.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZFH
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    List<UserRole> findByUserId(String userId);
}
