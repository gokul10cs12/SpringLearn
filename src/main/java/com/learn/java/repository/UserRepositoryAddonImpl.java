package com.learn.java.repository;

import com.learn.java.model.User;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAddonImpl implements UserRepositoryAddon{

    private final MongoTemplate template;

    public UserRepositoryAddonImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public User findByName(String name, String location) {
        Query query = new Query();
        Criteria criteria = Criteria.where("name").is(name)
                .andOperator(Criteria.where("location").is(location));
        query.addCriteria(criteria);
        return template.findOne(query, User.class);
    }

    @Override
    public User updateUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(user.getName()));
        Update update = new Update();
        update.set("date_of_birth", user.getDOB()).set("location", user.getLocation());
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true);

        return  template.findAndModify(query, update, options, User.class);
    }
}
