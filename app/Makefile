.DEFAULT_GOAL := install-run

setup:
	./gradlew wrapper --gradle-version 8.5

build:
	./gradlew clean build

install:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

clean:
	./gradlew clean

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

install-run: install run-dist

.PHONY: build test