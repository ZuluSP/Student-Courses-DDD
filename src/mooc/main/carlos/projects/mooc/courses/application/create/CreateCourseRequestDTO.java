package carlos.projects.mooc.courses.application.create;

import java.util.Objects;

public final class CreateCourseRequestDTO {
        private final String id;
        private final String name;
        private final String duration;

        public CreateCourseRequestDTO(String id, String name, String duration) {
                this.id = id;
                this.name = name;
                this.duration = duration;
        }

        public String id() { return id; }

        public String name() {
            return name;
        }

        public String duration() {
            return duration;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCourseRequestDTO that = (CreateCourseRequestDTO) o;
        return  Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
