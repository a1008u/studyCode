variable "aws_access_key" {}
variable "aws_secret_key" {}
variable "region" {
    default = "ap-northeast-1"
}

variable "images" {
    default = {
        us-east-1 = "ami-1ecae776"
        us-west-2 = "ami-e7527ed7"
        us-west-1 = "ami-d114f295"
        eu-west-1 = "ami-a10897d6"
        eu-central-1 = "ami-a8221fb5"
        ap-southeast-1 = "ami-68d8e93a"
        ap-southeast-2 = "ami-fd9cecc7"
        ap-northeast-1 = "ami-cbf90ecb"
        sa-east-1 = "ami-b52890a8"
    }
}
 
provider "aws" {
    access_key = "${var.aws_access_key}"
    secret_key = "${var.aws_secret_key}"
    region = "${var.region}"
}

resource "aws_vpc" "testVPC" {
    cidr_block = "10.0.0.0/16"
    instance_tenancy = "default"
    enable_dns_support = "true"
    enable_dns_hostnames = "false"
    tags {
      Name = "testVPC"
    }
}

resource "aws_subnet" "public-subnet" {
    vpc_id = "${aws_vpc.testVPC.id}"
    cidr_block = "10.0.1.0/24"
    availability_zone = "ap-northeast-1a"
}

resource "aws_subnet" "private-subnet" {
    vpc_id = "${aws_vpc.testVPC.id}"
    cidr_block = "10.0.11.0/24"
    availability_zone = "ap-northeast-1a"
}

resource "aws_internet_gateway" "myGW" {
    vpc_id = "${aws_vpc.testVPC.id}"
}


resource "aws_route_table" "public-route" {
    vpc_id = "${aws_vpc.testVPC.id}"
    route {
        cidr_block = "0.0.0.0/0"
        gateway_id = "${aws_internet_gateway.myGW.id}"
    }
    
    route {
    	cidr_block = "10.0.1.0/24"
    	gateway_id = "${aws_internet_gateway.main.id}"
    }
    
    tags {
    	Name = "main"
  	}
}
 


resource "aws_internet_gateway" "myGW" {
    vpc_id = "${aws_vpc.myVPC.id}" # myVPCのid属性を参照
}


resource "aws_instance" "example" {
  ami           = "ami-2757f631"
  instance_type = "t2.micro"
}
