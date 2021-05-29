#!/bin/bash

filename=$1
input1=$2
input2=$3

amount=0

arr=("")

while read line;
do
    if [[ ${line^^} == *${input1^^}* ]] && [[ ${line^^} == *${input2^^}* ]]
    then
        if [ $amount -lt 3 ] 
        then
            separator=' '
            read -ra split_line <<< "$line"

            for i in "${split_line[@]}";
            do
                if [[ ${i^^} == *"FULFILLED=FALSE"* ]];
                then
                    arr+=("$line")
                    amount=`expr $amount + 1`
                fi
            done
        else
            break
        fi
    else 
        unavailable=true
    fi
done < $filename

if [ $amount -le 0 ]
then 
    echo "We do not have that on the menu"
else
    printf '%s\n' "${arr[@]}" | sort -n
fi