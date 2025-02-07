#!/bin/bash

FILE_UNDER_WATCH=links.txt
LAST_TIME=$(stat -f "%t%Sm" $FILE_UNDER_WATCH)

while true    
do
   CURSOR_TIME=$(stat -f "%t%Sm" $FILE_UNDER_WATCH)    
   if [[ "$CURSOR_TIME" != "$LAST_TIME" ]]
   then    
        echo "TRACER: re-generating index.html"
        ./refresh.sh
        LAST_TIME="$CURSOR_TIME"
   fi
   sleep 3
done
