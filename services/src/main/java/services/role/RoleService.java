package services.role;

import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;

import java.util.List;

/**
 * Created by Corentin on 20/06/2017.
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Integer id) {
        return roleRepository.findRoleByRoleId(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public boolean exists(Integer id) {
        return roleRepository.exists(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleRepository.deleteRoleByRoleId(id);
    }
}
