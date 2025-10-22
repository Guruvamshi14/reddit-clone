package com.reddit.repo;


import com.reddit.model.CommentVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CommentVoteRepo extends JpaRepository<CommentVote, Long> {
    Optional<CommentVote> findById(Long aLong);
}
