package com.loicmaria.api.controller;

import com.loicmaria.api.model.Publisher;
import com.loicmaria.api.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Publisher")
public class PublisherController {
    
    @Autowired
    PublisherServiceImpl publisherService;

    /**
     * Create - Add a new publisher
     * @param publisher An object publisher
     * @return The publisher object saved
     */
    @PostMapping("/publisher")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }


    /**
     * Read - Get one publisher 
     * @param id The id of the publisher
     * @return An Publisher object full filled
     */
    @GetMapping("/publisher/{id}")
    public Publisher getPublisher(@PathVariable("id") int id) {
        Optional<Publisher> publisher = publisherService.get(id);
        if(publisher.isPresent()) {
            return publisher.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all publishers
     * @return - An Iterable object of Publisher full filled
     */
    @GetMapping("/publishers")
    public Iterable<Publisher> getPublishers() {
        return publisherService.getter();
    }

    /**
     * Update - Update an existing publisher
     * @param id - The id of the publisher to update
     * @param publisher - The publisher object updated
     * @return The currentPublisher if he is present or null
     */
    @PutMapping("/publisher/{id}")
    public Publisher updatePublisher(@PathVariable("id") int id, @RequestBody Publisher publisher) {
        Optional<Publisher> e = publisherService.get(id);
        if(e.isPresent()) {
            Publisher currentPublisher = e.get();

            String name = publisher.getName();
            if(name != null) {
                currentPublisher.setName(name);
            }
            publisherService.save(currentPublisher);
            return currentPublisher;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an publisher
     * @param id - The id of the publisher to delete
     */
    @DeleteMapping("/publisher/{id}")
    public void deletePublisher(@PathVariable("id") int id) {
        publisherService.delete(id);
    }
}
