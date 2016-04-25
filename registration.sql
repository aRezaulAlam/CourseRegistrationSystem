-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2016 at 07:16 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `registration`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  `adminname` varchar(255) NOT NULL,
  `adminid` varchar(255) NOT NULL,
  `adminpassword` varchar(255) NOT NULL,
  `adminrole` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `adminname`, `adminid`, `adminpassword`, `adminrole`) VALUES
(1, 'Admin', '12345', '12345', 'Central');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `courseid` varchar(255) NOT NULL,
  `coursename` varchar(255) NOT NULL,
  `credit` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `courseid`, `coursename`, `credit`) VALUES
(1, 'CSE101', 'C++', 3),
(2, 'CSE201', 'Java', 3),
(3, 'CSE205', 'Data Structure', 3),
(4, 'CSE308', 'Algorithm', 4),
(5, 'MTH302', 'Math IV', 4),
(6, 'CSE300', 'Software Development', 3),
(7, 'CSE405', 'Software Engineering', 3),
(8, 'CSE407', 'Network', 2),
(9, 'CSE450', 'Design Pattern', 2.5),
(10, 'CSE433', 'Python', 2);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE IF NOT EXISTS `faculty` (
  `id` int(11) NOT NULL,
  `facultyid` varchar(255) NOT NULL,
  `facultyname` varchar(255) NOT NULL,
  `facultypassword` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `facultyid`, `facultyname`, `facultypassword`) VALUES
(1, '100100', 'Morshed Hasan', '100100'),
(2, '20878', 'Jack Sparrow', '20878'),
(3, '66666', 'Tom Podi', '66666'),
(4, '010101', 'Nitesh Ahmed', '010101'),
(5, '195858', 'Shah Alam', '195858'),
(6, '101010', 'Alamgit Hyder', '101010'),
(7, '123456', 'Rana Ahmad', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `faculty_skills`
--

CREATE TABLE IF NOT EXISTS `faculty_skills` (
  `id` int(11) NOT NULL,
  `facultyid` varchar(255) NOT NULL,
  `courseid` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty_skills`
--

INSERT INTO `faculty_skills` (`id`, `facultyid`, `courseid`) VALUES
(1, '100100', 'CSE101'),
(2, '100100', 'CSE201'),
(3, '100100', 'CSE205'),
(4, '100100', 'CSE308'),
(5, '100100', 'CSE300'),
(6, '100100', 'CSE405'),
(7, '100100', 'CSE433'),
(8, '20878', 'CSE101'),
(9, '20878', 'CSE308'),
(10, '20878', 'MTH302'),
(11, '20878', 'CSE450'),
(12, '66666', 'CSE205'),
(13, '66666', 'MTH302'),
(14, '66666', 'CSE300'),
(15, '66666', 'CSE405'),
(16, '010101', 'CSE101'),
(17, '010101', 'CSE308'),
(18, '010101', 'CSE407'),
(19, '010101', 'CSE450'),
(20, '010101', 'CSE433'),
(21, '195858', 'CSE201'),
(22, '195858', 'CSE205'),
(23, '195858', 'CSE308'),
(24, '195858', 'MTH302'),
(25, '101010', 'CSE101'),
(26, '101010', 'CSE300'),
(27, '101010', 'CSE407'),
(28, '101010', 'CSE450'),
(29, '101010', 'CSE433'),
(30, '123456', 'CSE101'),
(31, '123456', 'CSE201'),
(32, '123456', 'CSE205'),
(33, '123456', 'CSE308'),
(34, '123456', 'MTH302'),
(35, '123456', 'CSE300'),
(36, '123456', 'CSE433');

-- --------------------------------------------------------

--
-- Table structure for table `registered_course`
--

CREATE TABLE IF NOT EXISTS `registered_course` (
  `id` int(11) NOT NULL,
  `course_id` varchar(255) NOT NULL,
  `faculty_id` varchar(255) NOT NULL,
  `admin_id` varchar(255) NOT NULL,
  `classroom` varchar(255) NOT NULL,
  `timetable` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_course`
--

INSERT INTO `registered_course` (`id`, `course_id`, `faculty_id`, `admin_id`, `classroom`, `timetable`, `description`) VALUES
(1, 'CSE201', '195858', 'Central', 'D405', 'Sunday 12-2 PM & Tuesday 2-4 PM', 'Java Basic Course for 2nd Year 1st Semester'),
(2, 'CSE308', '20878', 'Central', 'D400', 'Monday 8-11 AM & Thursday 12-1 PM', 'Algorithm Basic Course for 2nd Year 1st Semester'),
(3, 'CSE205', '195858', 'Central', 'E300', 'Monday 2-5 PM', ' Basic Course for 3nd Year 1st Semester'),
(4, 'CSE407', '101010', 'Central', 'E306', 'Wednesday  2-5 PM', ' Basic Course for 3nd Year 1st Semester'),
(5, 'MTH302', '20878', 'Central', 'E302', 'Saturday  9-11 AM', ' Basic Course for 3nd Year 2st Semester'),
(6, 'CSE433', '123456', 'Central', 'C100', 'Saturday  1-3 AM', 'Software Development using Python'),
(7, 'CSE450', '010101', 'Central', 'C100', 'Monday  1-3 PM', 'Design Pattern'),
(8, 'CSE405', '66666', 'Central', 'C100', 'Tuesday  1-3 PM', 'Software Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `studentid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `major` varchar(25) NOT NULL,
  `mobile` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `studentid`, `password`, `major`, `mobile`) VALUES
(1, 'AKM Rezaul Alam', '12201051', 'skytech09', 'CSE', '01515667948'),
(2, 'Nahid Hasan', '12201011', '123456', 'CSE', '016567532'),
(3, 'Sajid Ahmad', '12201028', '232323', 'CSE', '0168787878');

-- --------------------------------------------------------

--
-- Table structure for table `student_course_registration`
--

CREATE TABLE IF NOT EXISTS `student_course_registration` (
  `id` int(11) NOT NULL,
  `course_id` varchar(255) NOT NULL,
  `studentid` varchar(255) NOT NULL,
  `permitted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `faculty_skills`
--
ALTER TABLE `faculty_skills`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_course`
--
ALTER TABLE `registered_course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_course_registration`
--
ALTER TABLE `student_course_registration`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `faculty_skills`
--
ALTER TABLE `faculty_skills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `registered_course`
--
ALTER TABLE `registered_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `student_course_registration`
--
ALTER TABLE `student_course_registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
