package carlos.projects.apps.mooc.command;

import carlos.projects.shared.infrastructure.cli.ConsoleCommand;

public final class AnotherFakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        info("This is ANOTHER fake comand");
    }
}
