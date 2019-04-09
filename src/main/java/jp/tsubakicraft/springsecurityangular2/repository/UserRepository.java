package jp.tsubakicraft.springsecurityangular2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.tsubakicraft.springsecurityangular2.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}