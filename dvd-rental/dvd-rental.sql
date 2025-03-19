-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Mar 2025 pada 07.05
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dvd-rental`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dvds`
--

CREATE TABLE `dvds` (
  `dvd_id` int(11) NOT NULL,
  `is_new` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `dvds`
--

INSERT INTO `dvds` (`dvd_id`, `is_new`, `title`, `director`, `genre`, `rating`, `release_date`) VALUES
(1, b'1', 'Silent Hill', 'Christophe Gans', 'Horror', 'Very Good', '2006-10-13'),
(2, b'0', 'Kuasa Gelap', 'Bobby Prasetyo', 'Horror', 'Good', '2024-10-03'),
(3, b'1', 'The Captain', 'Robert Schwentke', 'History, Drama', 'Good', '2017-09-07'),
(4, b'1', 'The Raid', 'Gareth Evans', 'Martial Art, Action', 'Very Good', '2012-03-21'),
(5, b'0', 'The Raid 6', 'Gareth Evans', 'Action, Drama', 'Overwhelmingly Good', '2025-01-15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `fines`
--

CREATE TABLE `fines` (
  `id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `reason` enum('DAMAGED','LATE_RETURN','LOST','OTHER') DEFAULT NULL,
  `rental_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `fines`
--

INSERT INTO `fines` (`id`, `amount`, `reason`, `rental_id`) VALUES
(1, 60000, 'DAMAGED', 1),
(2, 100000, 'LOST', 2),
(4, 60000, 'DAMAGED', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `members`
--

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `members`
--

INSERT INTO `members` (`member_id`, `contact_info`, `name`) VALUES
(1, '90813413212', 'Andi Pratama'),
(2, '08912233490', 'Budi Andoek'),
(3, '129092823', 'Nugraha Aris'),
(4, '894890121', 'Rita Novitasari'),
(5, '43572388912', 'Indah Larasati');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rentals`
--

CREATE TABLE `rentals` (
  `rental_id` int(11) NOT NULL,
  `cost` double NOT NULL,
  `fine` double NOT NULL,
  `rental_date` datetime(6) DEFAULT NULL,
  `rental_duration` int(11) NOT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `dvd_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rentals`
--

INSERT INTO `rentals` (`rental_id`, `cost`, `fine`, `rental_date`, `rental_duration`, `return_date`, `dvd_id`, `member_id`) VALUES
(1, 10000, 60000, '2025-03-17 20:38:01.000000', 4, '2025-03-21 20:38:01.000000', 1, 1),
(2, 117000, 100000, '2025-03-12 08:24:26.000000', 13, '2025-03-25 08:24:26.000000', 3, 2),
(3, 54000, 0, '2025-03-18 08:24:26.000000', 3, '2025-03-20 08:24:26.000000', 2, 4),
(4, 120000, 60000, '2025-03-18 08:36:17.000000', 7, '2025-03-25 08:36:17.000000', 5, 4),
(5, 50000, 0, '2025-03-17 08:36:17.000000', 5, '2025-03-22 08:36:17.000000', 4, 5);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dvds`
--
ALTER TABLE `dvds`
  ADD PRIMARY KEY (`dvd_id`);

--
-- Indeks untuk tabel `fines`
--
ALTER TABLE `fines`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rental_id` (`rental_id`);

--
-- Indeks untuk tabel `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`member_id`);

--
-- Indeks untuk tabel `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`rental_id`),
  ADD KEY `FKh4fq6o4e0hvnmyi2t3cygk3fp` (`dvd_id`),
  ADD KEY `FKiv7jhf7s4baoiyfp7gu54go3h` (`member_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `dvds`
--
ALTER TABLE `dvds`
  MODIFY `dvd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `fines`
--
ALTER TABLE `fines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `members`
--
ALTER TABLE `members`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `rentals`
--
ALTER TABLE `rentals`
  MODIFY `rental_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `fines`
--
ALTER TABLE `fines`
  ADD CONSTRAINT `fines_ibfk_1` FOREIGN KEY (`rental_id`) REFERENCES `rentals` (`rental_id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `rentals`
--
ALTER TABLE `rentals`
  ADD CONSTRAINT `FKh4fq6o4e0hvnmyi2t3cygk3fp` FOREIGN KEY (`dvd_id`) REFERENCES `dvds` (`dvd_id`),
  ADD CONSTRAINT `FKiv7jhf7s4baoiyfp7gu54go3h` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
