package com.students.task.service;

import com.students.task.Repository.UserRepository;
import com.students.task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository useRepo;

    @Override
    public List<User> getUser(){
        return useRepo.findAll();
    }

    @Override
    public void save(User user){
        useRepo.save(user);
    }

   /* @Override
    public User findById(Integer id){
        Optional<User> userResult = useRepo.findById(id);
        User user = null;
        if(userResult.isPresent()){
            user = userResult.get();
        }
        return user;
    }*/

@Override
    public User findById(Integer id){
    return useRepo.findById(id).get();
}

@Override
    public void updateUser(Integer id,User user){
    User UserFromDb = useRepo.findById(id).get();
    System.out.println(UserFromDb.toString());
   // UserFromDb.setId(user.getId());
    UserFromDb.setEmail(user.getEmail());
    UserFromDb.setPassword(user.getPassword());
    UserFromDb.setFirstName(user.getFirstName());
    UserFromDb.setLastName(user.getLastName());
    UserFromDb.setActive(user.isActive());
    UserFromDb.setActive(user.isDeleted());
    useRepo.save(UserFromDb);

}
@Override
    public void deleteUser(Integer id){
    useRepo.deleteById(id);
}

}
