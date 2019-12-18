
build:
	@ mvn verify -U

docker-build:
	@ docker build -t atix-7 .
