# ===============================================================
# public
# ===============================================================
## ----------------------------------------------
## instance
## ----------------------------------------------
resource "aws_instance" "web-server" {
  ami                    = "${data.aws_ami.amazon_linux.id}"
  instance_type          = "t2.micro"
  key_name               = "${var.key_name}"
  subnet_id              = "${aws_subnet.vpc-1-public-subnet.id}"
  vpc_security_group_ids = ["${aws_security_group.web-sg.id}"]

  associate_public_ip_address = true
  private_ip                  = "10.0.1.10"

  tags {
    Name = "web-server"
  }
}

## ----------------------------------------------
## instance - allocation(eip)
## ----------------------------------------------
resource "aws_eip_association" "web" {
  instance_id = "${aws_instance.web-server.id}"
  allocation_id = "${var.eip}"
}

## ----------------------------------------------
## security_group
## ----------------------------------------------
resource "aws_security_group" "web-sg" {
  name   = "web-sg"
  vpc_id = "${aws_vpc.vpc-1.id}"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags {
    Name = "web-sg"
  }
}


# ===============================================================
# private
# ===============================================================
## ----------------------------------------------
## instance
## ----------------------------------------------
resource "aws_instance" "db-server" {
  ami                    = "${data.aws_ami.amazon_linux.id}"
  instance_type          = "t2.micro"
  key_name               = "${var.key_name}"
  subnet_id              = "${aws_subnet.vpc-1-private-subnet.id}"
  vpc_security_group_ids = ["${aws_security_group.db-sg.id}"]

  private_ip = "10.0.100.10"

  tags {
    Name = "db-server"
  }
}

resource "aws_security_group" "db-sg" {
  name   = "db-sg"
  vpc_id = "${aws_vpc.vpc-1.id}"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8
    to_port     = 0
    protocol    = "icmp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags {
    Name = "db-sg"
  }
}
