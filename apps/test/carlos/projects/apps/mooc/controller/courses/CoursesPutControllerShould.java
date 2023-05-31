package carlos.projects.apps.mooc.controller.courses;

import carlos.projects.apps.RequestTestCase;
import org.junit.jupiter.api.Test;

/**
 * Checks the Courses Controller functionality
 */
final class CoursesPutControllerShould extends RequestTestCase {
    @Test
    public void create_a_valid_course() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/courses/db2c1f2b-b13c-4c57-8570-e2230c86da13",
                "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
                201
        );
    }
}
