#!/bin/sh

var=`curl http://www.amazon.cn/gp/bestsellers/books/660993051/ref=pd_zg_hrsr_b_1_4_last | grep "title=\"实现领域驱动设计\"" | grep zg_rankNumber | egrep -o '[0-9]\.<' | cut -d "." -f1`
echo $(date +"%m-%d-%Y"),$var >> aa.txt