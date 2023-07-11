package com.pangan.pagingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/paging")
public class PagingController {

    private final PagingRepository pagingRepository;

    @Autowired
    public PagingController(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    @PostMapping
    public PagingObject add(@RequestBody PagingObject pagingObject) {
        return pagingRepository.save(pagingObject);
    }

    @GetMapping
    public Page<PagingObject> getAll(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("contentSize") Integer contentSize) {
        Pageable pageable = PageRequest.of(pageNumber, contentSize);
        Page<PagingObject> pagingObjectPage = pagingRepository.findAll(pageable);
        return pagingObjectPage;
    }
}
