#!/bin/bash
#
#  Run the selfbus home server
#

topDir=`dirname $0`
if [ -n "$topDir" ]; then
   cd "$topDir" || (echo "Cannot chdir into $topDir"; exit 1)
fi

set -x
java -cp 'lib/*' org.selfbus.sbhome.web.WebServer
