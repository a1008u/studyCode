resource "aws_elb" "dev_elb" {
  name               = "dev-elb"
  availability_zones = ["${availability_zone}"]
  subnets            = ["${aws_subnet.vpc-1-public-subnet.id}"]

  security_groups = [
    "${aws_security_group.http-sg.id}",
  ]

  listener {
    instance_port     = 80
    instance_protocol = "http"
    lb_port           = 80
    lb_protocol       = "http"
  }

  health_check {
    healthy_threshold   = 2
    unhealthy_threshold = 2
    timeout             = 5
    target              = "HTTP:80/"
    interval            = 30
  }

  instances                   = ["${aws_instance.web-server.id}"]
  cross_zone_load_balancing   = true
  idle_timeout                = 400
  connection_draining         = true
  connection_draining_timeout = 400

  tags {
    Environment = "Development"
    Name        = "dev-elb"
    Role        = "ELB"
  }
}

## ----------------------------------------------
## security_group **external**
## ----------------------------------------------
resource "aws_security_group" "http-sg" {
  vpc_id      = "${aws_vpc.vpc-1.id}"
  name        = "http"
  description = "Allow http inbound traffic"

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
    Name = "http"
  }
}
