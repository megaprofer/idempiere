
build:
	@ mvn verify -U

docker-build: build
	@ docker build -t atix-7