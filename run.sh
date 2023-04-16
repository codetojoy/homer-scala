#!/bin/bash

set -e

sbt "run ./links.txt ./index.html"
