package com.hotel.hotelPrak.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Long idUser;

    @NotBlank(message = "Имя пользователя является обязательным")
    private String username;

    @NotBlank(message = "Пароль является обязательным")
    @Size(min = 8, message = "Длина пароля должна составлять не менее 8 символов")
    private String password;

    private boolean active;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;

    public UserModel() {
    }

    public UserModel(Long idUser, String username, String password, boolean active, Set<RoleEnum> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public @NotBlank(message = "Имя пользователя является обязательным") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Имя пользователя является обязательным") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Пароль является обязательным") @Size(min = 8, message = "Длина пароля должна составлять не менее 8 символов") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Пароль является обязательным") @Size(min = 8, message = "Длина пароля должна составлять не менее 8 символов") String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }
}