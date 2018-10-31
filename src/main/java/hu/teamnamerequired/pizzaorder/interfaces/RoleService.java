package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.dao.Role;

public interface RoleService {
    Role createRole(Role role);
    void deteleRole(Long roleId);

}
