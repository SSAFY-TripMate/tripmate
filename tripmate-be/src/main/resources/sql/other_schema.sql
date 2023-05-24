CREATE TABLE IF NOT EXISTS `member` (
  `member_no` int PRIMARY KEY auto_increment,
  `id` varchar(32) NOT NULL unique,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` char(1) NOT NULL CHECK(gender IN ('M', 'F')),
  `birth` timestamp NOT NULL,
  `created_time` timestamp DEFAULT current_timestamp,
  `token` varchar(1000) DEFAULT null
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `mate` (
  `mate_no` int PRIMARY KEY auto_increment,
  `sido_code` int,
  `start_date` timestamp,
  `end_date` timestamp,
  `preference_no` int,
  `capacity` int,
  `contact` varchar(1000),
  `title` varchar(1000) NOT NULL,
  `content` text NOT NULL,
  `member_no` int NOT NULL,
  `hit` int DEFAULT 0,
  `created_time` timestamp DEFAULT current_timestamp,
  FOREIGN KEY (sido_code) REFERENCES sido(sido_code),
  FOREIGN KEY (member_no) REFERENCES `member`(member_no) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `mate_thumbnail` (
  `mate_thumbnail_no` int PRIMARY KEY auto_increment,
  `mate_no` int NOT NULL,
  `image_folder` varchar(1000) NOT NULL,
  `image_origin_name` varchar(255) NOT NULL,
  `image_save_name` varchar(255) NOT NULL,
  `image_type` varchar(255) NOT NULL,
  FOREIGN KEY (mate_no) REFERENCES mate(mate_no)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `mate_comment` (
  `mate_comment_no` int PRIMARY KEY auto_increment,
  `mate_no` int NOT NULL,
  `content` text NOT NULL,
  `member_no` int NOT NULL,
  `created_time` timestamp DEFAULT current_timestamp,
  FOREIGN KEY (mate_no) REFERENCES mate(mate_no) ON DELETE CASCADE,
  FOREIGN KEY (member_no) REFERENCES `member`(member_no)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `preference` (
  `preference_no` int PRIMARY KEY auto_increment,
  `title` varchar(1000) NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO preference (title)
VALUES ('인생샷'),('맛집탐방'),('활동적'),('계획적'),('자유로움'),('쇼핑'),('자연'),('휴양');
