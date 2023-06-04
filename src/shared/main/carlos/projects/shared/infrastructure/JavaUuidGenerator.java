package carlos.projects.shared.infrastructure;

import carlos.projects.shared.domain.Service;
import carlos.projects.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
