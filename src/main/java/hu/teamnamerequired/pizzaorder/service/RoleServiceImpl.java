package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.dao.Role;
import hu.teamnamerequired.pizzaorder.interfaces.RoleService;
import hu.teamnamerequired.pizzaorder.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepo;
    @Override
    public Role createRole(Role user) {
        return roleRepo.save(user);
    }

    @Override
    public void deteleRole(Long roleId) {
        final Role currUser=roleRepo.findById(roleId).get();
        roleRepo.delete(currUser);
    }

}
