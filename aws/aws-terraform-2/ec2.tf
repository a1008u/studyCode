# ===============================================================
# public
# ===============================================================
## ----------------------------------------------
## instance
## ----------------------------------------------
resource "aws_instance" "entrance-server" {
  ami                    = "${data.aws_ami.amazon_linux.id}"
  instance_type          = "t2.micro"
  key_name               = "${var.key_name}"
  subnet_id              = "${aws_subnet.vpc-1-public-subnet.id}"
  vpc_security_group_ids = ["${aws_security_group.entrance-sg.id}"]

  associate_public_ip_address = true
  private_ip                  = "10.0.1.10"

  tags {
    Name = "entrance-server"
  }
}

## ----------------------------------------------
## instance - allocation(eip)
## ----------------------------------------------
resource "aws_eip_association" "entrance" {
  instance_id   = "${aws_instance.entrance-server.id}"
  allocation_id = "${var.eip}"
}

## ----------------------------------------------
## security_group **external**
## ----------------------------------------------
resource "aws_security_group" "entrance-sg" {
  name   = "entrance-sg"
  vpc_id = "${aws_vpc.vpc-1.id}"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["58.5.162.34/32"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags {
    Name = "entrance-sg"
  }
}

# ===============================================================
# private
# ===============================================================
## ----------------------------------------------
## instance
## ----------------------------------------------
resource "aws_instance" "web-server" {
  ami                    = "${data.aws_ami.amazon_linux.id}"
  instance_type          = "t2.micro"
  key_name               = "${var.key_name}"
  subnet_id              = "${aws_subnet.vpc-1-private-subnet.id}"
  vpc_security_group_ids = ["${aws_security_group.web-sg.id}"]

  private_ip = "10.0.100.10"

  tags {
    Name = "web-server"
  }
}

## ----------------------------------------------
## security_group **internal**
## ----------------------------------------------
resource "aws_security_group" "web-sg" {
  name        = "web-sg"
  vpc_id      = "${aws_vpc.vpc-1.id}"
  description = "Allow internal inbound traffic"

  ingress {
    from_port       = 22
    to_port         = 22
    protocol        = "tcp"
    security_groups = ["${aws_security_group.entrance-sg.id}"]
  }

  ingress {
    from_port       = 80
    to_port         = 80
    protocol        = "tcp"
    security_groups = ["${aws_security_group.http-sg.id}"]
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
