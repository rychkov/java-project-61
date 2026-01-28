run: clean build run-dist

clean:
	./gradlew clean

build: clean
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

.PHONY: run build