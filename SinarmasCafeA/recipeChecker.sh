#!/bin/bash

filename=$1
input=${2^^}

find=","
replace=""

apple=0
pineapple=0

while read line;
do
    fruit="${line/$find/$replace}"
    fruit=${fruit^^}

    # read $fruit

    if [[ $fruit == *PINEAPPLE* ]];
    then
        pineapple=`expr $pineapple + 1`
    elif [[ $fruit == *APPLE* ]];
    then
        apple=`expr $apple + 1`
    fi
done < $filename

case $input in
    "APPLE PIE")
        if [ $apple -ge 3 ]
        then
            echo "You shall have ${input}!"
        else
            echo "You shall not have ${input}!"
        fi ;;
    "PINEAPPLE PIE")
        if [ $pineapple -ge 3 ]
        then
            echo "You shall have ${input}!"
        else
            echo "You shall not have ${input}!"
        fi ;;
    "FRUIT PARFAIT")
        if [ $apple -ge 2 ] && [ $pineapple -ge 2 ]
        then
            echo "You shall have ${input}!"
        else
            echo "You shall not have ${input}!"
        fi ;;
    *)
        echo "We do not have that on the menu" ;;
esac



 