#!/usr/bin/env bash

set -e # Fail on error.
set +o noclobber # Ignore clobber.

log_file="full_build.log"
gradle_command="./gradlew" # Try and always use the wrapper file.

"$gradle_command" build wrapper javadoc | tee "$log_file"
