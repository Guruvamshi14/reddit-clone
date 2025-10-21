package com.reddit.repo;

import com.reddit.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepo extends JpaRepository<Community,Long>{
}
