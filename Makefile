.PONY: all build test

all: build

build:
	@gradlew build --warning-mode all

run:
	@gradlew :run

test:
	@gradlew :test --warning-mode all
