package carlos.projects.apps.mooc.controller.courses;

import carlos.projects.mooc.courses.application.create.CourseCreator;
import carlos.projects.mooc.courses.application.create.CreateCourseRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CoursesPutController {
    private CourseCreator creator;

    public CoursesPutController(CourseCreator creator) {
        this.creator = creator;
    }
    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<String> create(@PathVariable String id, @RequestBody Request request) {
        creator.create(new CreateCourseRequestDTO(id, request.name(), request.duration()));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

// I use setters due to springBoot, spring doesn´t use the constructor.
final class Request {
    private String name;
    private String duration;

    String name() {
        return name;
    }

    String duration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }
}
