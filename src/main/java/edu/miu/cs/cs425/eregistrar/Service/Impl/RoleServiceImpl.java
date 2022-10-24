package edu.miu.cs.cs425.eregistrar.Service.Impl;

import edu.miu.cs.cs425.eregistrar.Repository.RoleRepository;
import edu.miu.cs.cs425.eregistrar.Service.RoleService;
import edu.miu.cs.cs425.eregistrar.model.Role;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

}
