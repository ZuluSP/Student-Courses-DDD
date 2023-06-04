package carlos.projects.apps.mooc.command;

import carlos.projects.shared.infrastructure.cli.ConsoleCommand;

public final class FakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        info("This is a fake comand");
    }
}
