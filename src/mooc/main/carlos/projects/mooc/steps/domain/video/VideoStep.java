package carlos.projects.mooc.steps.domain.video;

import carlos.projects.mooc.steps.domain.Step;
import carlos.projects.mooc.steps.domain.StepId;
import carlos.projects.mooc.steps.domain.StepTitle;
import carlos.projects.shared.domain.VideoUrl;

public final class VideoStep extends Step {
    private final VideoUrl videoUrl;
    private final VideoStepText text;

    public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        super(id, title);

        this.videoUrl = videoUrl;
        this.text     = text;
    }

    private VideoStep() {
        super(null, null);

        this.videoUrl = null;
        this.text     = null;
    }
}