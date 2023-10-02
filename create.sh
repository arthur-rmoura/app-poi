#!/bin/sh
eb create \
	--instance_type t2.small \
	--keyname aws-appl-poi \
	--region sa-east-1 \
	--elb-type application \
	--vpc \
	--vpc.id vpc-e7f45783 \
	--vpc.ec2subnets subnet-31dadc68,subnet-36feab52 \
	--vpc.securitygroups sg-818ffae5 \
	--vpc.publicip