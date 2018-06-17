## ----------------------------------------------
## instance(nat)
## ----------------------------------------------
resource "aws_instance" "nat" {
  ami = "${var.amis.nat}"
  instance_type = "t2.micro"
  key_name = "${var.key_name}"
  vpc_security_group_ids = ["${aws_security_group.nat-sg.id}"]
  subnet_id = "${aws_subnet.vpc-1-public-subnet.id}"
  associate_public_ip_address = true
  source_dest_check = false

  tags {
    Name = "nat"
    Environment = "Common"
    Role = "NAT"
  }
}

## ----------------------------------------------
## security_group **internal**
## ----------------------------------------------
resource "aws_security_group" "nat-sg" {
  vpc_id = "${aws_vpc.vpc-1.id}"
  name = "nat"
  description = "Allow internal inbound traffic"

  ingress {
    from_port = 0
    to_port = 65535
    protocol = "tcp"
    cidr_blocks = ["${aws_vpc.vpc-1.cidr_block}"]
  }
  ingress {
    from_port = 0
    to_port = 65535
    protocol = "udp"
    cidr_blocks = ["${aws_vpc.vpc-1.cidr_block}"]
  }

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  tags {
    Name = "nat"
  }
}

