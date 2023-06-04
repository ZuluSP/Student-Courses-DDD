package carlos.projects.mooc.steps.domain.video;

import carlos.projects.mooc.steps.domain.StepId;
import carlos.projects.mooc.steps.domain.StepIdMother;
import carlos.projects.mooc.steps.domain.StepTitle;
import carlos.projects.mooc.steps.domain.StepTitleMother;
import carlos.projects.shared.domain.VideoUrl;
import carlos.projects.shared.domain.VideoUrlMother;

public final class VideoStepMother {
    public static VideoStep create(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        return new VideoStep(id, title, videoUrl, text);
    }

    public static VideoStep random() {
        return create(
                StepIdMother.random(),
                StepTitleMother.random(),
                VideoUrlMother.random(),
                VideoStepTextMother.random()
        );
    }
}