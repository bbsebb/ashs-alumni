--
-- PostgreSQL database dump
--


-- Dumped from database version 17.7
-- Dumped by pg_dump version 17.7

-- Started on 2026-01-08 17:30:42 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3471 (class 0 OID 16398)
-- Dependencies: 224
-- Data for Name: former_teammate_entity; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.former_teammate_entity VALUES
	('cd03d583-dba6-40a7-8aea-261d734daa45', 'Cedric', 'Ott', 1, '+33677752218', 'cedricott@msn.com', '1987-09-06', 2, 'VFBTHO', '1e48472c-1afd-4917-b89b-09ab8e1720ee'),
	('97293d6f-1c4c-41c6-8612-fe3982fc5d91', 'Myngoc', 'Tu', 0, '+33652568550', NULL, NULL, 2, 'SRMBHN', NULL),
	('19b7c259-94f6-4651-809d-d308b4350f0e', 'Adeline', 'Blanc', 0, '+33665961948', NULL, '1991-10-08', 2, 'YKSLWR', NULL),
	('1f416c0e-68f3-430f-8558-427275a45f61', 'Stephanie', 'Woloszyn', 0, '+33684751677', NULL, NULL, 2, 'CWSQCP', NULL),
	('f939127b-f40b-45e1-b157-cc88f0af45a9', 'matthieu', 'belhaddad', 1, '+33787963172', NULL, '1987-02-01', 2, 'RSOFXW', NULL),
	('40eb6f55-8411-41c1-8ca3-ec6afef5b318', 'Emmanuelle', 'Michel', 0, '+33664968387', 'emmanuellemichel67@gmail.com', '1980-08-27', 2, 'CKSTQR', '3b93e48f-08fd-4cc1-9e7d-a876571553bd'),
	('72ffb7dd-50b3-4cc9-8a28-df9dd18795f2', 'test', 'test', 1, NULL, NULL, NULL, 4, 'YDHJJP', NULL),
	('f1f4ffbe-1cfe-4f34-b5c4-3d41c2a4db34', 'Morgane', 'Guillec', 0, '+33625878942', NULL, NULL, 3, 'VQFEQF', NULL),
	('30b0c5e6-4580-439e-b8f8-7fd43fb55656', 'Elisabeth', 'Bastian', 0, '+33683365754', NULL, NULL, 3, 'KBWVMF', NULL),
	('a2e94284-c225-4063-8447-11175e49f030', 'Denis', 'Laurent', 1, '+33647787728', 'dns.laurent@live.fr', '1987-10-03', 2, 'OVXNKZ', NULL),
	('7a9928b8-a216-413c-8619-908f0e0d865d', 'Laurence', 'Plumeré', 0, NULL, NULL, NULL, 4, 'KCCQZB', NULL),
	('1599f73a-81e9-4a1e-8dbf-181773065bd7', 'Alex', 'Trajean', 1, '+33687346570', NULL, NULL, 2, 'PKYGFD', NULL),
	('69a77fc4-eeee-40cd-ad24-f80355990a6a', 'Stéphanie Gwen', 'Hubscher', 0, '+33676989058', 'stefi_bp@hotmail.com', '1983-10-11', 2, 'ZBYMEL', '374acd26-a635-4270-8077-cba0cc9da89d'),
	('6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', 'Isabelle', 'Karjouck', 0, '+33787116471', 'isabelle.karjouck@icloud.com', '1981-08-24', 2, 'QYPPEQ', '12dc4697-5b0d-46f2-bd5d-3e2764dee8ac'),
	('87526c43-8507-450c-b315-f2b6ed5d4833', 'Marie', 'Chaventon', 0, '+33619739111', 'marie.chaventon@yahoo.fr', '1990-06-22', 2, 'KHWTSQ', NULL),
	('0b3a5924-4c76-4776-8f1b-3704c83ef53e', 'Amelie', 'Trusch', 0, '+33650009161', NULL, NULL, 2, 'HIFQYY', NULL),
	('491f0284-7cd7-4994-9a7c-fe6c5a79dd26', 'Camille', 'Schwartz', 0, '+33678641933', NULL, NULL, 4, 'KFKSEU', NULL),
	('1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', 'Julie', 'Pfister', 0, '+33677916982', NULL, NULL, 4, 'AVYHQD', NULL),
	('99ee53bb-97cd-4ff2-90f9-c6e32792295b', 'Anthony', 'Matter', 1, '+33607872953', NULL, NULL, 4, 'XBHJUY', NULL),
	('769852c8-aece-4eec-9286-cf0ef65f3d75', 'Olivier', 'Ragot', 1, '+33661861732', NULL, NULL, 4, 'RYYYBN', NULL),
	('ecc78dae-6e27-42a3-a58b-302ecc8599a0', 'Yvan', 'Frindel', 1, '+33680622155', NULL, NULL, 4, 'BGZUUX', NULL),
	('c2955784-50db-4ff2-8d59-f8b5c6bc248f', 'Marie', 'Ott', 0, '+33684725466', NULL, NULL, 4, 'XBOSOQ', NULL),
	('4398bcec-fb29-41c3-8088-f8ca66120f21', 'Joanna', 'Woelfli', 0, '+33615354743', NULL, NULL, 2, 'VNHQGC', NULL),
	('91af7307-0c46-4276-8349-de60962d0017', 'Bruno', 'Goetzmann', 1, '+33649874965', NULL, NULL, 6, 'XPMMXQ', NULL),
	('8bc693cd-3537-4dcd-8717-39b24bf56086', 'Raymond', 'Zilliox', 1, '+33685218647', 'zilliox.raymond@wanadoo.fr', NULL, 2, 'EIYOVB', NULL),
	('ee5e141a-341b-4c9e-a82c-e500bbcae527', 'Jérome', 'Meyer', 1, '+33624630236', 'jmeyer@alsalux.fr', '1979-01-31', 2, 'UUVVON', NULL),
	('2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', 'Florian', 'Baehr', 1, '+33648374023', 'floo.baehr@gmail.com', '1990-03-18', 2, 'PXUZGK', NULL),
	('db1ecd95-b0bf-4581-99b0-955622143a74', 'Simon', 'Borja', 1, '+33645079205', NULL, NULL, 6, 'QMLXOH', NULL),
	('bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', 'Christophe', 'Helbourg', 1, '+33681432541', 'Cheesehelb67@gmail.com', '1975-12-06', 2, 'WSUANE', NULL),
	('0cd6f3ff-3bd3-4264-8093-ef0d19accddb', 'Celine', 'Noel', 0, '+33638760440', NULL, NULL, 2, 'VFXXJJ', NULL),
	('319de8c0-be99-4210-9ecc-ba43c0c7e382', 'Éric', 'Nicora', 1, '+33607827250', 'eric.nicora@free.fr', '1975-10-24', 2, 'XLAXUD', NULL),
	('fef02115-d090-4a47-92af-bc51cc7b0557', 'Emeline', 'Esselin', 0, '+33642931441', 'emeline.esselin@gmail.com', '1987-08-04', 2, 'PJHIEF', NULL),
	('d713af8b-da0d-432f-8ff3-747605cd040f', 'Sarah', 'Reich', 0, '+33673186830', 'reichsarah@yahoo.fr', '1985-09-17', 2, 'IMSDMG', NULL),
	('ca6789af-a398-4263-919b-026439df484b', 'Cécile', 'Monnier', 0, '+33687675235', NULL, '1987-11-30', 2, 'DMVFTY', NULL),
	('b63e0a87-088b-4a54-8ce9-619b09ecaf74', 'Chantal', 'Reuther', 0, '+33685504977', NULL, NULL, 3, 'DCUKKP', NULL),
	('e5ac925d-9240-4a5e-b935-b55bb80911cf', 'Annabelle', 'Roos', 0, '+33606368422', NULL, NULL, 4, 'RVRVEZ', NULL),
	('f468aa64-a23c-4aab-a66b-c21eaeddb403', 'Audrey', 'Thomas', 0, '+33602035797', 'audrey.thomas67@icloud.com', '1980-10-16', 2, 'ANDBNJ', 'ee0db7e3-b441-42fd-a913-b421d07f9c84'),
	('a43cce16-e1d6-4c13-b440-0499a81de6f2', 'Mathieu', 'Blanchard', 1, '+33663787744', NULL, '1975-01-01', 2, 'RTBARW', NULL),
	('9f874782-653f-4272-b659-090ed53cb7f9', 'Alain', 'Rieffel', 1, '+33783064624', NULL, NULL, 4, 'KJVQCV', NULL),
	('83d8b6a1-7494-4643-b500-dcfe7f887380', 'Michel', 'AMIEL', 1, '+33683173610', NULL, '1971-04-09', 2, 'GMDJCS', NULL),
	('d10d34ca-889c-4390-b31d-c7b320b8313f', 'Jérôme ', 'Fritsch ', 1, '+33678271384', NULL, '1984-04-01', 2, 'SETJQA', NULL),
	('4b484c05-af0f-4c94-a259-e214b49edf23', 'Clara', 'Oswald', 0, '+33618146084', NULL, NULL, 2, 'BXGFCM', NULL),
	('c0308668-8d76-433e-9855-22b0e3ab59dc', 'Joffrey', 'Moraida', 1, '+33672341680', 'moraida.joffrey@hotmail.fr', '1988-02-12', 2, 'GXOUJA', 'ed14a168-c095-47d8-8ff2-34fd835d7486'),
	('d2db5300-7888-4d3e-9a2c-9c1e20373c50', 'Flavie', 'Mehn', 0, '+33661574851', 'flavie.mehn4@gmail.com', '1998-03-02', 2, 'QHQKJZ', NULL),
	('2fe6c647-c716-4154-a571-28753717d427', 'Marion', 'Ott', 0, '+33631865534', NULL, NULL, 2, 'ZYQXSA', NULL),
	('f3087033-2aaf-4c80-b2b6-2706bf5d2f09', 'François', 'Gless', 1, '+33610961982', 'francois.gless@hotmail.com', '1987-12-26', 2, 'ZISQIG', NULL),
	('827fbb3f-b98c-49a2-b9a2-0316d08b07a5', 'Lauréline ', 'L’hotellier', 0, '+33623331594', 'laurelinelhotellier@hotmail.fr', '1987-10-09', 2, 'SNTZWE', '97835508-db5d-4f4d-8e6b-8812055cd822'),
	('47b5f9ca-ca9a-440b-8416-5509730c4385', 'Sandra', 'Ringenbach', 0, '+33617684016', 'gergonzales@wanadoo.fr', '1979-06-24', 2, 'PMPNGC', NULL),
	('88a61b77-620e-412d-9cba-14e58872b26c', 'Lucas', 'Wagner', 1, '+33610612709', NULL, NULL, 2, 'XMPTWE', NULL),
	('e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', 'Jérome', 'Fritsch', 1, '+33607430571', NULL, '1984-01-04', 2, 'VNOJIQ', NULL),
	('07c6873b-8105-45a8-b3b9-3687ee8b291a', 'Arthur', 'Brugnano', 1, '+33689516915', 'arthur.brugnano@free.fr', '2000-07-14', 2, 'ZXDAQA', NULL),
	('c0c8e3cc-f36b-4f46-8767-3586065ecbd5', 'Sébastien', 'Narducci', 1, '+33689211383', NULL, NULL, 2, 'RVLJBP', '698824fd-e633-4f48-9af4-198b473e2659'),
	('5ec6fe34-c77e-4c34-86f4-5bdd380661b5', 'Lou-Anne', 'Cora', 0, '+33635714555', NULL, NULL, 6, 'YFJQGN', NULL),
	('8b6d633f-1ff3-4b19-bb40-27a69834346f', 'Marc', 'Hamm', 1, '+33620265215', NULL, NULL, 4, 'ZHMDAA', NULL),
	('375ec00e-5499-4018-ab66-88a095c7b0fd', 'Michel-Jean', 'Amiel', 1, '+33683713610', NULL, NULL, 5, 'HFHGBK', NULL),
	('742f15ee-f9c1-43a5-821a-ccf08bec61a3', 'Yannick', 'Lienhart', 1, '+33644101315', NULL, NULL, 2, 'DDBWOD', 'a284548b-447e-40c7-bba0-ed6d1f065f29'),
	('f5cbddca-eebf-4432-8afb-0f84c8c2f217', 'Nicolas', 'CARON', 1, '+33661499794', 'Nicoc68@hotmail.com', '1983-04-28', 2, 'YCHTGA', NULL),
	('d542946e-ddbe-440f-b74c-c608f2e6593d', 'Stephan ', 'EHRMANN', 1, '+33628233540', 'pressepuree74@wanadoo.fr', '1974-07-07', 2, 'QCWGFY', NULL),
	('4f907f34-d778-4bed-a54c-b56446702069', 'Kévin', 'Beretta', 1, '+33760808161', 'kevin.beretta7@gmail.com', '1990-05-18', 2, 'DKMGFS', 'c250c6bc-685e-446b-986b-0cc66643d907'),
	('9e508539-e73c-4654-b219-9e3401fa82c5', 'Quentin', 'Mitoire', 1, '+33608153036', NULL, NULL, 2, 'PNXYXF', NULL),
	('27993ea4-ccad-469d-9e53-5f479a6f036f', 'Fantine', 'Charbonniere', 0, '+33684354559', 'fantine.charbo@gmail.com', '2001-10-25', 2, 'KOHUFC', '843d3bb8-d1aa-41fb-9b69-46a8fdd04fce'),
	('b185044e-bd20-4a55-8797-c56e26ae8b55', 'Thomas', 'Pfister', 1, '+33650422408', 'thomas.pfister84@gmail.com', '1984-11-11', 2, 'TJBJIT', NULL),
	('16271680-19a8-4184-a754-337364221875', 'Philippe', 'Wernert', 1, '+33673426632', NULL, NULL, 4, 'AGLEEW', NULL),
	('0209207d-26cb-4278-823d-c674ce7bea10', 'Remi', 'Watrin', 1, '+33677557348', 'remiwatrin@gmail.com', '1989-12-27', 2, 'JCKJVG', '6037f3ec-1abd-4fbb-83d0-6d70a8b44417'),
	('f2ece8fd-c279-4af5-8771-90fa9375a3b5', 'François', 'Goetzmann', 1, '+33632407584', 'francois_goetzmann@yahoo.fr', '1988-02-10', 2, 'ZZGKPQ', '77a3d739-3ddc-483e-b1de-07adc975966d'),
	('c067b1d2-1523-46ab-b67b-eec7ea218603', 'Jules', 'Ehrmann', 1, '+33769792266', 'jules.ehrmann@gmail.com', '2005-06-04', 2, 'BBITSP', NULL),
	('b03d5b1c-74cc-4ec8-9dfb-528494803a4d', 'Olivier', 'Mauvilain', 1, '+33661892899', NULL, NULL, 4, 'DGFJJB', NULL),
	('2c2e4e41-9026-44b3-a096-5a3721de91f1', 'Didier', 'Diebolt', 1, '+33608045070', NULL, NULL, 4, 'LKZJQB', NULL),
	('5b94d080-af97-41fe-a0b9-54b462a0aebc', 'Baptiste', 'Leclercq', 1, '+33647430956', NULL, '1993-09-04', 2, 'NVMXJT', 'cecf1b06-1f5e-47c6-a3a1-3422b08c442f'),
	('0d5eb5c0-b6ad-4900-80d4-24b70bdb2494', 'Yann', 'Wechsler', 1, NULL, NULL, NULL, 4, 'JNAKMK', NULL),
	('fc81bc18-e7af-4e11-a3b7-48c02b2ca2c0', 'Cédric', 'Wechsler', 1, NULL, NULL, NULL, 4, 'PXLOZQ', NULL),
	('d1d093b1-9017-41eb-8418-5a59a6bcc01e', 'Eric', 'Letzelter', 1, '+33669143595', NULL, NULL, 4, 'RNSXVQ', NULL),
	('52c217bc-54c2-421b-bb66-398feb93a958', 'Celia', 'Wahl Heyd', 0, '+33648176732', NULL, NULL, 4, 'HYISTJ', NULL),
	('5e9c8545-96d0-4a92-9079-70a861999f35', 'Michel', 'Carlucci', 1, '+33611443117', NULL, NULL, 4, 'QMQSHO', NULL),
	('fe662c82-532b-4d52-8de5-ba4effa67703', 'Florian', 'Riviere', 1, '+33615182224', 'florian.riviere67@gmail.com', '1994-11-16', 2, 'ALUPUJ', NULL),
	('0f8d6245-a78e-4854-9ec6-bbbc18887277', 'Marcky', 'Raharison', 1, '+33677915553', NULL, NULL, 2, 'QVRWUT', NULL),
	('37ed2a8e-0aad-4908-9abe-c46bb19c4153', 'Jean-philippe', 'MALL', 1, '+33604650942', 'jipize@gmail.com', '1991-08-13', 2, 'IDNVJG', NULL),
	('7201762a-7198-4814-a5d0-389915ff3aae', 'Mounir', 'Mohamed Ben Ali', 1, '+33783265261', 'mbam67@gmail.com', '1984-08-05', 2, 'YQAEVX', '58d165e0-3dc7-4174-85b0-3c6d75d514c4'),
	('cdfe9872-39f7-4b2b-8d6c-28105af47b0d', 'Christophe', 'Georger', 1, '+33626216291', NULL, NULL, 4, 'WEQLWV', NULL),
	('f570075c-a0f6-4f85-9697-4a313d73bcde', 'Laurent', 'Zilliox', 1, '+33661249828', NULL, NULL, 3, 'PMQIJT', NULL),
	('3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', 'Laurie ', 'Moosmann', 0, '+33616798932', 'laurie.moosmann@gmail.com', '1998-09-15', 2, 'XJYMIQ', NULL),
	('24777749-e3ab-49c7-9bcb-82127cf86474', 'Alain', 'Kommerschlag', 1, NULL, NULL, NULL, 4, 'PSROOZ', NULL),
	('b54716dd-d3d6-45d2-9534-e8a338656f1f', 'Edouard', 'Broehl', 1, NULL, NULL, NULL, 4, 'PAUKFK', NULL),
	('53f49bd7-41bb-44b9-bdee-e975bdcd062f', 'Richard', 'SCHOETTEL', 1, NULL, NULL, NULL, 4, 'VWVZTZ', NULL),
	('b9c5ea85-b37e-4fc5-96a3-5fe2dbd9cb09', 'Jacky', 'FRITSCH', 1, NULL, NULL, NULL, 4, 'UACGAU', NULL),
	('6286226d-398a-44d6-b94a-eb614707bf93', 'Joseph', 'FRITSCH', 1, NULL, NULL, NULL, 4, 'OJRWMN', NULL),
	('cb5b702b-6e9a-49e3-b594-e01b88504fe5', 'Jean paul', 'Bianchi', 1, NULL, NULL, NULL, 4, 'WTWEDA', NULL),
	('05c6e24d-7094-4602-a429-d30dcb004a9f', 'Jean Maris', 'Krieger', 1, NULL, NULL, NULL, 4, 'EFIHTX', NULL),
	('33f42380-fc0d-48d0-ad9a-d962600fe2bc', 'Jean Marc', 'Spielmann', 1, NULL, NULL, NULL, 4, 'SYPAUS', NULL),
	('4641ff7e-36de-4767-8123-5efde5e01f39', 'Marcky', 'Funfrock', 1, NULL, NULL, NULL, 4, 'KBGPHV', NULL),
	('1dd7af56-8dd9-451f-9b14-ce03441f8589', 'Didier', 'TROESCH', 1, NULL, NULL, NULL, 4, 'GMGHNB', NULL),
	('15f0cced-441a-40bb-bf61-00d086363946', 'MARC', 'Segaux', 1, NULL, NULL, NULL, 4, 'JCDVHS', NULL),
	('ff95a114-a898-47f4-bfaf-bf3b79ee1f6e', 'LE FRERE', 'Segaux', 1, NULL, NULL, NULL, 4, 'YSLZHK', NULL),
	('5a67bbe0-58e7-4d63-98e8-433df60e7e1d', 'Pierre-alban', 'Karli', 1, '+33659706203', NULL, NULL, 2, 'OZNWNR', NULL),
	('2cd0c3ac-b710-4f8a-8791-33eab9142483', 'Pierre', 'Trautmann', 1, '+33610220533', 'pierre.trautmann67@gmail.com', '1972-05-24', 2, 'DQJEUZ', NULL),
	('aa585d61-6ec4-4be2-b637-b0cb16a830cb', 'Clement', 'Schmitt', 1, '+33679159125', 'smt.clement@gmail.com', '1991-09-07', 2, 'OFUTCV', NULL),
	('8d141563-9b62-4b6d-a7c6-b7851d63a519', 'Michel', 'Schneeberger', 1, '+33687450613', 'michel.schneeberger@orange.fr', '1966-10-25', 2, 'CAVVQM', NULL),
	('5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', 'Franco', 'Carlucci', 1, '+33699047451', 'car2fra@gmail.com', '1973-01-06', 2, 'TBWCAT', NULL),
	('22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', 'Jérôme', 'Baehr', 1, '+33608035361', NULL, NULL, 2, 'VGIGGY', NULL),
	('92470fa0-c720-47d4-94a1-ce68637c18b3', 'Philippe', 'Thomas', 1, '+33614392050', 'ashshand.philippe@orange.fr', '1959-05-11', 2, 'RQLNAV', '3c1336ed-0ddf-47b5-8de1-b22c52dfcd7e'),
	('9913046a-680a-42fc-8c33-1c7cc517aeef', 'Celia', 'Schub', 0, '+33659200650', 'celia.schub@gmail.com', '1987-06-10', 2, 'FGQCZG', NULL),
	('cd97f0bf-6845-4b2e-8af4-c1a239519783', 'Thierry', 'Colnot', 1, '+33615730409', 'tcolnot2@gmail.com', '1970-08-09', 2, 'UQOUPA', '53875499-4002-48d7-90a2-dce0f4790b07'),
	('84aba313-5d27-48c0-96a6-6f99441becc5', 'Thierry', 'Debargue', 1, '+33632764948', 'thierry.debargue@gmail.com', '1975-02-14', 2, 'MABJQW', '58b14f0b-f1fe-4f44-915f-08178852697e'),
	('e4f45475-565e-40da-a9f4-bf7afee5e649', 'SEBASTIEN', 'BURCKHARDT', 1, '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 2, 'OTJEQI', NULL),
	('6d5e0bb5-60f6-4ddd-94f7-d827d806117e', 'Murielle', 'Kircher', 0, '+33698046114', NULL, '1976-01-30', 2, 'HYUATR', NULL),
	('36820e75-1d05-4eeb-aa1f-9ebb5394fab9', 'Clément ', 'Daul', 1, '+33611432510', 'daulclement@gmail.com', '2000-10-19', 2, 'CXVMYD', NULL),
	('970c6a61-0010-4770-8ff2-a3b703e5cc8c', 'SEBASTIEN', 'BURCKHARDT', 1, '+33638937416', 'sebastien.burckhardt@gmail.com', '1969-01-01', 2, 'CQQVQP', NULL),
	('9fddca8e-be3c-48e7-a0bb-025359db6063', 'Eve', 'Bacci', 0, '+33676604921', 'eve.bacci@hotmail.fr', '1995-03-21', 2, 'MNYYLJ', 'ee16bfbe-4196-4240-8ac8-fccc2ce1a101'),
	('06f72afb-571c-470a-9d04-ca83edc9010f', 'Philippe', 'Lamaack', 1, '+33662353483', 'p.lamaack@orange.fr', '1974-06-10', 2, 'HPLJMD', NULL),
	('a0434ad6-faa7-4503-9db5-a32c64fd3e6e', 'Maeva ', 'Voisin', 0, '+33785599530', 'maeva.voisin@gmail.com', '1992-03-20', 2, 'EXYWSF', NULL),
	('bb30e395-fcce-47eb-9290-2672151e1a4b', 'Nicolas', 'Metzger', 1, '+33699349915', 'n.metzger1720@gmail.com', '1997-11-19', 2, 'UHSKQA', NULL),
	('b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', 'Claire', 'Manigold', 0, '+33662813036', 'claire.manigold@hotmail.fr', '1991-04-25', 2, 'MRQWRJ', NULL),
	('ae764e76-fb96-44fc-b1da-28a2a8d507b0', 'SEBASTIEN', 'BURCKHARDT', 1, '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 2, 'QRCLMN', 'e30ecc8f-161a-48a2-8850-efa0e170de58'),
	('fee443a9-634b-497a-8d0b-ffc6e835307d', 'Mathieu', 'Weibel', 1, '+33623367833', 'mathwbu@gmail.com', '1974-01-25', 2, 'KCSIBT', 'd3ac6803-0d88-4f9e-aabc-523de6a94ad7'),
	('79e356bb-3520-4058-857d-9605a1580986', 'Virginie', 'Kohler', 0, '+33610076463', 'viny.k67@gmail.com', '1981-05-09', 2, 'MNIFMY', NULL),
	('01cde600-5078-48b4-8d6f-94069c0fb7c3', 'Lucas', 'Felten', 1, '+33665759670', NULL, '1990-01-07', 2, 'URMPRD', NULL),
	('e1b1b0ca-dc2d-458e-a592-23b893f74d09', 'Amélie', 'TRUSCH', 0, '+33623182464', 'amelietrusch@gmail.com', '1981-03-19', 2, 'REINRD', '7f5c0a8c-cc9d-4aee-922b-6e7b4f20f122'),
	('d75f7556-001c-4e7f-a5f9-90ac61db8e9e', 'Alex', 'Adrioni', 0, '+33662382730', NULL, NULL, 4, 'SFGIUQ', NULL),
	('f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', 'Momo', 'Sahli', 1, '+33627657584', 'moha.sahli@hotmail.fr', '1977-03-04', 2, 'ETRLSD', '4fc20240-a790-4cf0-9153-463fa4358591'),
	('0976c3c5-8505-490b-beb0-07e9999a9aa0', 'Melanie', 'Chaouch', 0, '+33650768107', NULL, NULL, 2, 'LUURPL', NULL),
	('5f1b11b3-2599-41eb-8ec8-75584d9e97b5', 'Myriam', 'Jacob', 0, '+33636177610', NULL, NULL, 4, 'YCXMMI', NULL),
	('f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', 'Bruno', 'MOUTARDE', 1, '+33688968541', NULL, NULL, 4, 'RTUMAC', NULL),
	('c013befe-a972-44be-86de-7996756f4402', 'Bertrand', 'ZUGMEYER', 1, '+33777073500', 'berzug@yahoo.fr', '1975-03-29', 2, 'CPRVMI', 'd5e9b7ee-f1de-4861-8035-8a219ac61673'),
	('3af6f2b8-1760-4d5c-b08c-7e100d33335d', 'Damba', 'Camara', 0, '+33771271612', 'camaradamba@gmail.com', '1993-12-16', 2, 'CGAUOJ', '3fbce212-9b6f-4aca-8d91-18fc049cda74'),
	('58fd23db-ac36-4dfe-aa28-e93a9e7797f8', 'Éric', 'Chautant', 1, '+33615072092', 'eric.chautant@yahoo.fr', '1972-12-05', 2, 'XTHYAL', '07289510-fc22-4aea-818e-53ddddf7beae'),
	('d4c86b2f-0fb4-4176-b031-29ef3c4f2f43', 'Caroline', 'Moitrier', 0, '+33698637607', NULL, NULL, 4, 'UVICCS', NULL),
	('638e9607-ce5d-465d-b39f-1671ee6dff09', 'Gilles', 'Fiege', 1, '+33612400854', 'gillesfiege@gmail.com', '1981-08-07', 2, 'MVIUEF', '3261c027-515e-4749-afd2-e29dc47e3591'),
	('d0c975f7-14b4-496e-b2f4-e18afacab64d', 'Marie', 'Reich', 0, '+33612572685', NULL, '1961-01-01', 2, 'ZMZAZL', 'c8daf5b4-e7ab-4924-adea-51bce899d44b'),
	('691203e0-1a28-4c25-aaf2-a47eed1a03f7', 'Guillaume', 'Reich', 1, '+33627261147', NULL, '1984-07-04', 2, 'HTDPHT', '82e28815-c4d0-4f16-9956-926c1933fc3e'),
	('c76145f4-3bbe-420a-9873-1410b3b7aff4', 'Jonathan', 'Willaume', 1, '+33670667723', 'john-twelve@hotmail.fr', '1984-07-25', 2, 'FRESIR', '808599bf-be4a-4eb1-915e-e32b23539142'),
	('4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', 'Christelle', 'Himber', 0, '+33684190357', 'kris.80@hotmail.fr', '1980-02-11', 2, 'TEBDDH', '850bd015-cd66-4819-aa64-e77ab964c6b5'),
	('cc6be365-6e48-4469-b86e-4b92265778fc', 'Luc', 'Walliser', 1, '+33629332926', 'luc.walliser67500@gmail.com', '2000-10-07', 2, 'UENCYW', '86617cb5-db33-43ad-9d56-3c6f49dc35d8'),
	('35ea7b95-05f1-4541-8f4f-e707ebb36f26', 'Michael', 'Hauler', 1, '+33675275474', 'michael.hauler@gmail.com', NULL, 2, 'LLBDBA', 'aa92297a-f2bd-4b62-9ae0-8b23bd6cf3b3'),
	('ba093cf9-93bd-4dca-ada6-d58fa4b56089', 'My Duyen', 'Tu', 0, '+33664852133', 'my.tu1988@outlook.fr', '1988-07-22', 2, 'CEAOPT', 'd8e34a82-eb4a-4d1e-8cbc-51810ee04a77'),
	('86834cac-f4fc-44a1-b536-f3d38643c835', 'Nelida', 'Garcia', 0, '+33664538190', 'nelaespa@gmail.com', '1960-04-14', 2, 'MRMTKJ', '133ac679-7eed-4b4d-a1af-bbda44df0115'),
	('a543bbd8-04ae-4074-bc43-10de8c0aba69', 'Olivia', 'Kwiatkowski', 0, '+33661868329', 'oliviak68@hotmail.com', '1983-03-13', 2, 'NSQYCQ', '30297fb5-a7fe-4c9d-ae06-3f3ebaa42bdf'),
	('0840c04c-05c0-45f8-ab6c-e2778a3b3744', 'Celine', 'Wolff (Ott)', 0, '+33634277641', 'ottceline81@gmail.com', '1981-03-24', 2, 'ZIPLXH', 'b46f397e-b4fb-47a8-a245-d8ba89f42502'),
	('10040925-2d1d-461a-9f0b-9eefc08e625c', 'Peggy', 'Dos Santos', 0, '+33671827337', 'peggy.santos@hotmail.fr', '1977-09-09', 2, 'KMUIBK', '5877bdb2-73a7-4f96-97db-6b582d6ad91e'),
	('2ba82819-525c-4a00-b3ee-ede5331d987e', 'Pascale', 'Reymann', 0, '+33685093793', NULL, NULL, 4, 'NWAZTK', NULL),
	('34f4e53c-8f9d-4a4d-a07c-457d66d90cef', 'Vanessa', 'Roos', 0, '+33663216526', NULL, NULL, 4, 'EJLAIF', NULL),
	('70a55248-c199-4274-9ec6-2806f142979a', 'Pharel', 'PONGAULT', 1, '+33755279646', NULL, NULL, 4, 'ISRUOW', NULL),
	('769f4031-9580-48cb-a31d-130276cc82ba', 'Guy', 'Bischof', 1, '+33611169698', 'guytoutcc@gmail.com', '1969-12-06', 2, 'JBHLNG', 'b2121434-6ce1-45a5-8673-f555c37f3802'),
	('711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', 'Fabrice', 'Andres', 1, '+33643042588', 'af.andres.fabrice@gmail.com', '1973-01-10', 2, 'JKIWXV', 'd8962801-8690-4e7d-abe7-2b0e023268a7'),
	('efe3d9ea-5c59-4c10-94d9-5ad5e711be32', 'Michel', 'Mutschler', 1, '+33612470381', 'chelmi@evc.net', '1968-04-24', 2, 'LODSQW', NULL),
	('9405013c-4909-428d-aebe-35686e7d857f', 'Jean', 'De Nicola', 1, '+33783799874', 'jean.de-nicola@orange.fr', '1997-06-29', 2, 'BPXFXL', '39a930c3-4cb6-4002-831c-49b23bdd12ea'),
	('658117c8-99f5-4390-8949-f209b4c28482', 'Quentin', 'Munch', 1, '+33644249796', 'qqmunch@gmail.com', '1988-06-23', 2, 'EUUGMM', '8b341545-b439-4356-9ff0-227845010dfb'),
	('81f643d7-7f27-41f1-94ac-7791cd52980e', 'Étienne', 'Borges', 1, '+33645196472', NULL, '1991-12-10', 2, 'PTKJRT', '21472681-a8d6-4bde-8a0a-cd22e6960a82'),
	('2875e641-45a6-4367-80c5-a2d5e73b6652', 'Guillaume', 'Mathon', 1, '+33781452688', 'guillaumemthn@gmail.com', NULL, 2, 'QXPQXC', NULL),
	('af5f3625-3325-4eb2-ba62-65c1f48c378b', 'Patrice', 'Wagentrutz', 1, '+33683849305', 'pat.wagen@hotmail.fr', '1985-06-19', 2, 'MRCNMG', NULL),
	('f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', 'Walfroy', 'MEUNIER', 1, '+33618844228', 'walfroy.meunier@laposte.net', '1991-04-07', 2, 'ARSROU', NULL),
	('20a4dd11-e5f3-49eb-b316-752601087c89', 'Adrien', 'Jacob', 1, '+33630117869', 'adrienjacob85@gmail.com', '1985-06-17', 2, 'DUWEEU', '229db36f-20f8-42c0-9138-7daba8a38250'),
	('528a0d26-5637-4f6f-94fc-1afcecdaf115', 'Florian ', 'Wiedmann', 1, '+33676442573', 'fwiedemann123@gmail.com', '1995-01-02', 2, 'YSIJAA', NULL),
	('979e0719-1ea0-4c38-a00a-7423415a076e', 'Nadine', 'Jordan ', 0, '+33622471106', 'nadine.balla@sft.fr', '1978-04-07', 2, 'UALFFU', 'e3fd479d-44c2-45c5-b4da-89187b26279b'),
	('537e2f3c-b831-4ad6-8b2a-e000da83d21c', 'Céline', 'Bognitscheff', 0, '+33614590972', 'celine.bognitscheff@gmail.com', '1987-04-21', 2, 'RTNLEX', NULL),
	('e556d632-a2b9-4de1-be35-f813c522e1e4', 'Kévin', 'Jennesson', 1, '+33631174335', NULL, NULL, 4, 'HQHJON', NULL),
	('3f3547be-0221-4543-ba5b-fba485a0ecf6', 'Jeje - Jérome ', 'Bacchiani', 1, '+33670523009', 'jeromebacchiani@gmail.com', '1971-02-07', 2, 'IAJSOF', NULL),
	('43f2ab3f-7636-4f33-a7ac-bbe794680310', 'Cheima', 'Gharbi', 0, '+33613880756', 'Cheima.gharbif@gmail.com', '1992-06-26', 2, 'IDYLAZ', '95174847-af32-4eec-949b-8a9120f6c45c'),
	('3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', 'Fred', 'Cochard', 1, '+33684966107', NULL, NULL, 2, 'PTVDQP', NULL),
	('2b119672-1da0-459d-80aa-93cb1f43f0d3', 'Vivien', 'Gross', 1, '+33787788914', NULL, '1976-02-12', 2, 'GCSGGU', 'e7621fbb-8be1-414b-964b-6c762c5a6219'),
	('b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', 'Franck', 'Sturm', 1, '+33637110912', NULL, NULL, 2, 'MKLHKU', NULL),
	('259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', 'Stephane', 'Jacquemin', 1, '+33609836382', NULL, NULL, 4, 'OXWNGR', NULL),
	('1f1eae4c-2c39-420c-98c3-cc33ed0c481a', 'Cloé', 'Schwartz', 0, '+33689453454', NULL, NULL, 4, 'PFATCY', NULL),
	('27a46392-38fe-4150-8cb8-855b5e3d3556', 'Vincent', 'Ott', 1, '+33673262684', 'vott1984@gmail.com', '1984-01-01', 2, 'GLEGFJ', NULL),
	('1694358d-1b25-4a73-ac93-0ef533f4be44', 'Aymeric', 'Florent', 1, '+33682433457', 'florentaymeric@yahoo.com', NULL, 2, 'CTGNXZ', NULL),
	('ef507372-33fb-4b2c-80d3-d884aa46177d', 'Elisabeth', 'Scheyder', 0, '+33642436503', NULL, NULL, 4, 'WHTVWF', NULL),
	('1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', 'Carole', 'Buchle', 0, '+33782547924', NULL, NULL, 4, 'REKRKS', NULL),
	('ac779409-6fda-4707-a245-fd5ff88202c4', 'Florence', 'Walch', 0, '+33649281834', NULL, NULL, 4, 'RKPRCJ', NULL),
	('196319d4-61d8-4e5d-afc6-87a510146d50', 'Annick', 'Reuther', 0, '+33683923380', NULL, NULL, 4, 'FCCWTW', NULL),
	('eac7028e-f054-46c2-82d2-d9d656f1692b', 'Josie', 'Renneville', 0, '+33640646375', NULL, NULL, 4, 'ZQFWHQ', NULL),
	('f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', 'Victor', 'Yaacoub', 1, '+33606801230', NULL, NULL, 4, 'UQCUWA', NULL),
	('c421cc06-f20c-4fc6-8b1b-17650b38c9c5', 'Pauline', 'Gaudel', 0, '+33749177447', NULL, NULL, 4, 'HHZFLT', NULL),
	('c87726db-55ae-4a63-8cfe-81801092d087', 'Natacha', 'Farudjia', 0, '+33607343250', NULL, NULL, 4, 'ELHDPY', NULL),
	('d8d12de2-0744-4f2e-b54b-c6a703eaee43', 'Bruno', 'Thiebauld', 1, '+33667924388', NULL, NULL, 4, 'EZVKFA', NULL),
	('d7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', 'Martial', 'Aymonin', 1, '+33661527093', NULL, NULL, 4, 'MQCXCZ', NULL),
	('edec597f-7c61-4c46-8455-24192a607e50', 'Ursch', 'Nicolas', 1, '+33680518716', NULL, NULL, 4, 'RUVMKD', NULL),
	('6e77f176-7762-4993-970f-6715c66362b6', 'Carla', 'Plautz', 0, '+33777953119', NULL, NULL, 4, 'DNFRFO', NULL),
	('fe07d772-f789-44e5-88e6-f424d9dce984', 'Stevann', 'Jasek', 1, '+33616761014', 'stevann38@gmail.com', '1983-12-23', 2, 'ARFSDN', '518d829d-20cd-442f-8619-0330dfaae493'),
	('ae693e20-705e-4b03-b166-d4b34c2e4418', 'Thibaut', 'Jacob', 1, '+33761538893', 'jacob.thibaut@hotmail.fr', '1987-05-15', 2, 'UUBOCM', 'e527bcab-6eb4-4ce2-9f35-b3265c2b956c');


--
-- TOC entry 3472 (class 0 OID 16405)
-- Dependencies: 225
-- Data for Name: former_teammate_entity_roles; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.former_teammate_entity_roles VALUES
	('ae764e76-fb96-44fc-b1da-28a2a8d507b0', 1),
	('5b94d080-af97-41fe-a0b9-54b462a0aebc', 0),
	('fe662c82-532b-4d52-8de5-ba4effa67703', 0),
	('2875e641-45a6-4367-80c5-a2d5e73b6652', 0),
	('fe07d772-f789-44e5-88e6-f424d9dce984', 1),
	('fe07d772-f789-44e5-88e6-f424d9dce984', 0),
	('83d8b6a1-7494-4643-b500-dcfe7f887380', 0),
	('c067b1d2-1523-46ab-b67b-eec7ea218603', 0),
	('ae693e20-705e-4b03-b166-d4b34c2e4418', 0),
	('a0434ad6-faa7-4503-9db5-a32c64fd3e6e', 0),
	('91af7307-0c46-4276-8349-de60962d0017', 0),
	('0f8d6245-a78e-4854-9ec6-bbbc18887277', 1),
	('c0308668-8d76-433e-9855-22b0e3ab59dc', 0),
	('f1f4ffbe-1cfe-4f34-b5c4-3d41c2a4db34', 0),
	('30b0c5e6-4580-439e-b8f8-7fd43fb55656', 0),
	('2cd0c3ac-b710-4f8a-8791-33eab9142483', 0),
	('638e9607-ce5d-465d-b39f-1671ee6dff09', 0),
	('84aba313-5d27-48c0-96a6-6f99441becc5', 0),
	('84aba313-5d27-48c0-96a6-6f99441becc5', 1),
	('87526c43-8507-450c-b315-f2b6ed5d4833', 0),
	('f468aa64-a23c-4aab-a66b-c21eaeddb403', 0),
	('92470fa0-c720-47d4-94a1-ce68637c18b3', 0),
	('92470fa0-c720-47d4-94a1-ce68637c18b3', 2),
	('827fbb3f-b98c-49a2-b9a2-0316d08b07a5', 0),
	('3f3547be-0221-4543-ba5b-fba485a0ecf6', 0),
	('f3087033-2aaf-4c80-b2b6-2706bf5d2f09', 0),
	('01cde600-5078-48b4-8d6f-94069c0fb7c3', 0),
	('e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', 0),
	('e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', 1),
	('0840c04c-05c0-45f8-ab6c-e2778a3b3744', 0),
	('0840c04c-05c0-45f8-ab6c-e2778a3b3744', 3),
	('f939127b-f40b-45e1-b157-cc88f0af45a9', 0),
	('f5cbddca-eebf-4432-8afb-0f84c8c2f217', 0),
	('319de8c0-be99-4210-9ecc-ba43c0c7e382', 0),
	('537e2f3c-b831-4ad6-8b2a-e000da83d21c', 0),
	('ca6789af-a398-4263-919b-026439df484b', 0),
	('a543bbd8-04ae-4074-bc43-10de8c0aba69', 0),
	('8bc693cd-3537-4dcd-8717-39b24bf56086', 1),
	('ee5e141a-341b-4c9e-a82c-e500bbcae527', 1),
	('10040925-2d1d-461a-9f0b-9eefc08e625c', 0),
	('e1b1b0ca-dc2d-458e-a592-23b893f74d09', 0),
	('742f15ee-f9c1-43a5-821a-ccf08bec61a3', 0),
	('8d141563-9b62-4b6d-a7c6-b7851d63a519', 0),
	('3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', 0),
	('1f416c0e-68f3-430f-8558-427275a45f61', 0),
	('efe3d9ea-5c59-4c10-94d9-5ad5e711be32', 0),
	('cc6be365-6e48-4469-b86e-4b92265778fc', 0),
	('5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', 0),
	('5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', 1),
	('1599f73a-81e9-4a1e-8dbf-181773065bd7', 0),
	('c76145f4-3bbe-420a-9873-1410b3b7aff4', 0),
	('4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', 0),
	('a2e94284-c225-4063-8447-11175e49f030', 0),
	('58fd23db-ac36-4dfe-aa28-e93a9e7797f8', 0),
	('fef02115-d090-4a47-92af-bc51cc7b0557', 0),
	('fef02115-d090-4a47-92af-bc51cc7b0557', 1),
	('efe3d9ea-5c59-4c10-94d9-5ad5e711be32', 1),
	('9913046a-680a-42fc-8c33-1c7cc517aeef', 0),
	('3af6f2b8-1760-4d5c-b08c-7e100d33335d', 0),
	('aa585d61-6ec4-4be2-b637-b0cb16a830cb', 0),
	('691203e0-1a28-4c25-aaf2-a47eed1a03f7', 0),
	('cd97f0bf-6845-4b2e-8af4-c1a239519783', 0),
	('d542946e-ddbe-440f-b74c-c608f2e6593d', 0),
	('d542946e-ddbe-440f-b74c-c608f2e6593d', 1),
	('2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', 0),
	('e4f45475-565e-40da-a9f4-bf7afee5e649', 0),
	('4398bcec-fb29-41c3-8088-f8ca66120f21', 0),
	('c013befe-a972-44be-86de-7996756f4402', 0),
	('c013befe-a972-44be-86de-7996756f4402', 1),
	('a43cce16-e1d6-4c13-b440-0499a81de6f2', 0),
	('35ea7b95-05f1-4541-8f4f-e707ebb36f26', 0),
	('f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', 0),
	('f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', 1),
	('22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', 0),
	('22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', 1),
	('d713af8b-da0d-432f-8ff3-747605cd040f', 0),
	('bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', 1),
	('0cd6f3ff-3bd3-4264-8093-ef0d19accddb', 0),
	('cd03d583-dba6-40a7-8aea-261d734daa45', 0),
	('4b484c05-af0f-4c94-a259-e214b49edf23', 0),
	('86834cac-f4fc-44a1-b536-f3d38643c835', 0),
	('d0c975f7-14b4-496e-b2f4-e18afacab64d', 0),
	('27a46392-38fe-4150-8cb8-855b5e3d3556', 0),
	('1694358d-1b25-4a73-ac93-0ef533f4be44', 0),
	('1694358d-1b25-4a73-ac93-0ef533f4be44', 1),
	('9405013c-4909-428d-aebe-35686e7d857f', 0),
	('b185044e-bd20-4a55-8797-c56e26ae8b55', 0),
	('9405013c-4909-428d-aebe-35686e7d857f', 1),
	('0209207d-26cb-4278-823d-c674ce7bea10', 0),
	('375ec00e-5499-4018-ab66-88a095c7b0fd', 0),
	('db1ecd95-b0bf-4581-99b0-955622143a74', 0),
	('36820e75-1d05-4eeb-aa1f-9ebb5394fab9', 0),
	('37ed2a8e-0aad-4908-9abe-c46bb19c4153', 0),
	('658117c8-99f5-4390-8949-f209b4c28482', 0),
	('7201762a-7198-4814-a5d0-389915ff3aae', 0),
	('af5f3625-3325-4eb2-ba62-65c1f48c378b', 0),
	('769f4031-9580-48cb-a31d-130276cc82ba', 1),
	('711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', 0),
	('d10d34ca-889c-4390-b31d-c7b320b8313f', 0),
	('d10d34ca-889c-4390-b31d-c7b320b8313f', 1),
	('9fddca8e-be3c-48e7-a0bb-025359db6063', 0),
	('bb30e395-fcce-47eb-9290-2672151e1a4b', 0),
	('97293d6f-1c4c-41c6-8612-fe3982fc5d91', 0),
	('2fe6c647-c716-4154-a571-28753717d427', 0),
	('19b7c259-94f6-4651-809d-d308b4350f0e', 0),
	('81f643d7-7f27-41f1-94ac-7791cd52980e', 0),
	('81f643d7-7f27-41f1-94ac-7791cd52980e', 1),
	('f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', 0),
	('69a77fc4-eeee-40cd-ad24-f80355990a6a', 0),
	('b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', 0),
	('6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', 0),
	('fee443a9-634b-497a-8d0b-ffc6e835307d', 0),
	('79e356bb-3520-4058-857d-9605a1580986', 0),
	('20a4dd11-e5f3-49eb-b316-752601087c89', 0),
	('f2ece8fd-c279-4af5-8771-90fa9375a3b5', 0),
	('528a0d26-5637-4f6f-94fc-1afcecdaf115', 0),
	('979e0719-1ea0-4c38-a00a-7423415a076e', 0),
	('43f2ab3f-7636-4f33-a7ac-bbe794680310', 3),
	('ba093cf9-93bd-4dca-ada6-d58fa4b56089', 0),
	('9e508539-e73c-4654-b219-9e3401fa82c5', 0),
	('47b5f9ca-ca9a-440b-8416-5509730c4385', 0),
	('d2db5300-7888-4d3e-9a2c-9c1e20373c50', 0),
	('07c6873b-8105-45a8-b3b9-3687ee8b291a', 0),
	('27993ea4-ccad-469d-9e53-5f479a6f036f', 0),
	('2b119672-1da0-459d-80aa-93cb1f43f0d3', 2);


--
-- TOC entry 3474 (class 0 OID 16427)
-- Dependencies: 227
-- Data for Name: former_teammate_history_entity; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.former_teammate_history_entity VALUES
	('b73e6051-8442-43f9-a095-c83e43a7d5a4', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', NULL, NULL, 0, '2025-12-06 03:46:20.343275', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('fe5a9864-f361-45ff-bd89-a47cff952803', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', NULL, NULL, 1, '2025-12-06 03:46:20.754092', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d440bb6e-5b38-4dc8-ba16-3c166e9af707', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 0, '2025-12-06 03:46:20.764182', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('53db58e8-bafd-4828-a5de-d5acc771f44c', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 1, '2025-12-06 03:46:21.286121', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('f8660c9f-2276-4151-9387-3dd73831ed25', '58fd23db-ac36-4dfe-aa28-e93a9e7797f8', '+33615072092', NULL, NULL, 0, '2025-12-06 03:46:21.292127', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('efb6c770-ad36-4235-a590-aa18db66ff39', '58fd23db-ac36-4dfe-aa28-e93a9e7797f8', '+33615072092', NULL, NULL, 1, '2025-12-06 03:46:21.798999', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('dfbe86c9-fc13-4bd7-9be5-ed33023c7488', '319de8c0-be99-4210-9ecc-ba43c0c7e382', '+33607827250', NULL, NULL, 0, '2025-12-06 03:46:21.807415', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('14cb238c-2744-479a-96f1-dad2873dde17', '319de8c0-be99-4210-9ecc-ba43c0c7e382', '+33607827250', NULL, NULL, 1, '2025-12-06 03:46:22.329187', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('819025cb-031a-425e-b584-752bd5d399af', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', NULL, NULL, 0, '2025-12-06 03:46:22.334883', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('140c5ef6-3fef-4600-8b90-1aa8c389dbfc', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', NULL, NULL, 1, '2025-12-06 03:46:22.638209', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a5c337df-58df-48d6-9b1b-a5bc1965c30b', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, NULL, 0, '2025-12-06 03:46:22.644203', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('db828bd6-985a-4ba6-a03d-fce0705bfd25', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, NULL, 1, '2025-12-06 03:46:23.144432', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('98078a4a-0819-492d-8305-c29e7c5c0d86', 'f1f4ffbe-1cfe-4f34-b5c4-3d41c2a4db34', '+33625878942', NULL, NULL, 0, '2025-12-04 21:45:20.506971', 0, 'Anonyme', 'Enregistrement initial'),
	('11f5f1ff-dc05-4b24-8ab3-9120fb1fbb0d', '30b0c5e6-4580-439e-b8f8-7fd43fb55656', '+33683365754', NULL, NULL, 0, '2025-12-04 21:45:47.423781', 0, 'Anonyme', 'Enregistrement initial'),
	('3805f5ca-9f6f-4b52-babb-6c5279944eb2', 'f1f4ffbe-1cfe-4f34-b5c4-3d41c2a4db34', '+33625878942', NULL, NULL, 3, '2025-12-04 21:46:18.898357', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. '),
	('000d0c0a-51fd-4af2-9f60-d2eb5e1c17af', '30b0c5e6-4580-439e-b8f8-7fd43fb55656', '+33683365754', NULL, NULL, 3, '2025-12-04 21:46:27.352613', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. '),
	('1d54bc5e-8081-4fe0-887a-215a8bad5884', 'f468aa64-a23c-4aab-a66b-c21eaeddb403', '+33602035797', NULL, NULL, 0, '2025-12-06 03:18:06.920062', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('4ff93351-3dd8-4b37-a38b-32f7f3ad6e9c', 'f468aa64-a23c-4aab-a66b-c21eaeddb403', '+33602035797', NULL, NULL, 1, '2025-12-06 03:18:08.136136', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('9d6954de-9709-4968-8c49-447550700d9e', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', NULL, NULL, 0, '2025-12-06 03:18:08.150682', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a4e744a3-a2fe-4d3e-926a-9d67e8d4a5ff', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', NULL, NULL, 1, '2025-12-06 03:18:08.705422', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bc1e4307-5974-4e7b-b463-96413c4b4fdc', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', NULL, NULL, 0, '2025-12-06 03:18:08.723062', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('cf706173-8f19-4c4b-aef2-9c0c357d1900', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', NULL, NULL, 1, '2025-12-06 03:18:09.208601', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('3c39628a-a454-47a5-9bbf-934e40d35339', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', NULL, NULL, 0, '2025-12-06 03:18:09.227898', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('df90c544-71eb-4a70-8280-8108eab2a5be', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', NULL, NULL, 1, '2025-12-06 03:18:09.755111', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e143454d-2b1d-4db0-87c1-220f66c49f00', '4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', '+33684190357', NULL, NULL, 0, '2025-12-06 03:18:09.770007', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('cdea5976-8841-452f-9e8a-814b228c22db', '4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', '+33684190357', NULL, NULL, 1, '2025-12-06 03:18:10.46504', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('80535a56-3c48-4d0c-b40b-e9cb54a16cda', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', NULL, NULL, 0, '2025-12-06 03:18:10.483195', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('230dce9b-154b-4503-89d5-304895ce54d7', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', NULL, NULL, 1, '2025-12-06 03:18:10.806069', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5a68e03a-52cf-4cf9-a79c-a79d292b8506', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', NULL, NULL, 0, '2025-12-06 03:18:10.818251', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1fbb8cb3-7140-4b39-8303-fde0806e043a', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', NULL, NULL, 1, '2025-12-06 03:18:11.337523', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('c75d109c-2912-401a-9424-9f582de521eb', 'fef02115-d090-4a47-92af-bc51cc7b0557', '+33642931441', NULL, NULL, 0, '2025-12-06 03:18:11.352122', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('27e1db4a-04f5-44d3-9555-cafb5407ab5c', 'fef02115-d090-4a47-92af-bc51cc7b0557', '+33642931441', NULL, NULL, 1, '2025-12-06 03:18:11.876475', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e7cb58db-1671-4228-976c-b155b64ec955', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', NULL, NULL, 0, '2025-12-06 03:18:11.893296', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('afa5f407-ad48-4845-8425-6c5bb0af3101', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', NULL, NULL, 1, '2025-12-06 03:18:12.208514', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bc036c99-e4f1-437e-8b7e-798e72dfa4c4', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 0, '2025-12-06 03:18:12.220433', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3c5cfa14-81b8-417e-bb71-9bafb3c56c94', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 1, '2025-12-06 03:18:12.736249', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('cf701816-1c5f-4472-ab08-48b39dafb064', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', NULL, NULL, 0, '2025-12-06 03:18:12.753083', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('2c28aec3-1d10-4e95-8b7b-1899f4913f2e', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', NULL, NULL, 1, '2025-12-06 03:18:13.262108', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a8a3187d-cc6b-4b55-88d0-34be902db563', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 0, '2025-12-06 03:18:13.277352', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a60586cb-01a5-4ed0-808e-c67ca6d71055', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 1, '2025-12-06 03:18:13.802048', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7e039989-720d-4189-816f-435afcd1e825', '10040925-2d1d-461a-9f0b-9eefc08e625c', '+33671827337', NULL, NULL, 0, '2025-12-06 03:18:13.816843', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c1a0aa5a-01ea-4fee-9db5-73f14528e73b', '10040925-2d1d-461a-9f0b-9eefc08e625c', '+33671827337', NULL, NULL, 1, '2025-12-06 03:18:14.134446', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bd94b0bd-7734-43b3-b801-d86c40097057', 'd713af8b-da0d-432f-8ff3-747605cd040f', '+33673186830', NULL, NULL, 0, '2025-12-06 03:18:14.14685', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c925b1d8-0664-43cc-beb9-bf10413e7008', 'd713af8b-da0d-432f-8ff3-747605cd040f', '+33673186830', NULL, NULL, 1, '2025-12-06 03:18:14.685814', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('65156398-a0fb-428a-807e-be6128cfdabd', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', NULL, NULL, 0, '2025-12-06 03:18:14.708934', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('64893c66-5480-4430-b7a3-b94f1a764e30', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', NULL, NULL, 1, '2025-12-06 03:18:15.01552', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e13720cb-afeb-4048-8694-4d1b08cb4229', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', NULL, NULL, 0, '2025-12-06 03:18:15.030907', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ede66913-0afc-47bc-b153-b1c90fe37fee', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', NULL, NULL, 1, '2025-12-06 03:18:15.575413', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('6f55faa9-127f-4d56-890c-a4e2dcf8b1d4', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', NULL, NULL, 0, '2025-12-06 03:18:15.58957', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d5ce5e67-5e38-4142-a685-25c828a55d12', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', NULL, NULL, 1, '2025-12-06 03:18:15.899523', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('701bb44e-fa28-4670-97bc-fd89ff64b3b3', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, NULL, 0, '2025-12-06 03:18:15.911174', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('2d5bce3b-6239-49ce-97c5-c26642a31bfd', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, NULL, 1, '2025-12-06 03:18:16.401668', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bdee7cef-3487-4cff-bdcc-31e04d08feca', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 0, '2025-12-06 03:18:16.411812', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('48ff9f87-3474-412f-be45-17972e1274b7', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 1, '2025-12-06 03:18:16.923044', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('dabda040-db3f-414a-8922-468038ff8caa', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 0, '2025-12-06 03:18:16.938313', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('666bf3ef-863d-4f10-b1ff-9355bf0e0abb', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 1, '2025-12-06 03:18:17.45003', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('72a2e345-6004-4ebd-b92c-4f0a67ed872b', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 0, '2025-12-06 03:18:17.464655', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3f78f96c-9da9-4c4e-9c43-4428a3043800', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 1, '2025-12-06 03:18:17.800171', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('202fcc4d-7ac9-4d6e-92f0-6ccc4fa8dcf8', '4398bcec-fb29-41c3-8088-f8ca66120f21', '+33615354743', NULL, NULL, 0, '2025-12-06 03:18:17.810209', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('4ccc7d0c-5f5c-45a9-b2a0-fbc6c6cc6d1e', '4398bcec-fb29-41c3-8088-f8ca66120f21', '+33615354743', NULL, NULL, 1, '2025-12-06 03:18:18.318764', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('890aa318-b57d-46f2-b08c-f3536e564257', '87526c43-8507-450c-b315-f2b6ed5d4833', '+33619739111', NULL, NULL, 0, '2025-12-06 03:18:18.333589', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('92dc8f6d-0d3e-438d-8948-943250cf7ff6', '87526c43-8507-450c-b315-f2b6ed5d4833', '+33619739111', NULL, NULL, 1, '2025-12-06 03:18:18.644649', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('ef1e0f2a-deba-49db-b6db-5b8b3a108c58', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 0, '2025-12-06 03:18:18.653593', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('78e1ce29-a9a6-4c79-a553-332a62405592', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 1, '2025-12-06 03:18:18.967588', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('2bca69fe-695f-4294-a82a-6f1a22d82b21', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 0, '2025-12-06 03:18:18.98242', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8edb0c65-e696-4cd0-986b-aad88a72f86a', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 1, '2025-12-06 03:18:19.489582', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('30ff56f3-049e-4d42-9ae9-0e2f5a03f420', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 0, '2025-12-06 03:18:19.513721', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('dfeebe93-b16f-4d87-a638-493917cc188b', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 1, '2025-12-06 03:18:19.829729', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('b0cc2c47-fd5e-4844-b126-0a3471308e82', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 0, '2025-12-06 03:18:19.843837', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e0edb76b-0c67-4273-9f05-fe876ed82194', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 1, '2025-12-06 03:18:20.363637', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('825ee190-6c95-4541-afe0-a28a9e0b3f53', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 0, '2025-12-06 03:18:20.377168', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('0e6b098a-6ab7-47db-80f2-eb9f035a6798', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 1, '2025-12-06 03:18:20.898062', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('77be8c03-b781-40c3-aa0d-11dffde9054c', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', NULL, NULL, 0, '2025-12-06 03:18:20.910404', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('eb4d9f5b-41a6-437c-a85c-459b44446166', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', NULL, NULL, 1, '2025-12-06 03:18:21.427115', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d930f0c4-1161-47ea-afaa-33c67a164fc6', '7a9928b8-a216-413c-8619-908f0e0d865d', '+33600000000', NULL, NULL, 0, '2025-12-06 03:18:21.448151', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1c1f3515-f159-4925-8b05-6cef4450e298', '7a9928b8-a216-413c-8619-908f0e0d865d', '+33600000000', NULL, NULL, 1, '2025-12-06 03:18:21.950776', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a9836e1a-cdbb-4382-b538-46bea12e701c', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', NULL, NULL, 0, '2025-12-06 03:18:21.964659', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5da43d1e-ffb9-4eb8-ac9d-cc04fdd9ffce', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', NULL, NULL, 1, '2025-12-06 03:18:22.471716', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('dedad440-0d2c-4890-8973-59e530c6da00', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 0, '2025-12-06 03:18:22.485685', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e03abac4-3ffd-47ec-b5d7-3b10d6c3a8e4', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 1, '2025-12-06 03:18:22.810684', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('45d5da17-6854-496a-ad31-a3fff8f7c5bf', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 0, '2025-12-06 03:18:22.823778', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e660c2a5-3d3c-4a10-a33e-4ec45a2d7923', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 1, '2025-12-06 03:18:23.328081', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('971577cd-e385-48e8-a723-889585b0f8ab', 'b63e0a87-088b-4a54-8ce9-619b09ecaf74', '+33685504977', NULL, NULL, 0, '2025-12-06 03:18:23.338325', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8da89283-6ae7-4f12-b16c-b74cfcdf168f', 'b63e0a87-088b-4a54-8ce9-619b09ecaf74', '+33685504977', NULL, NULL, 1, '2025-12-06 03:18:23.84238', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('182c93ea-6f04-4404-91e4-a39c9e6ef0da', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 0, '2025-12-06 03:18:23.854452', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('53507e24-b7e5-4f22-9229-2a214c8f5b16', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 1, '2025-12-06 03:18:24.180419', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('df2bb8ed-d323-4627-bd1e-ccc7aebf5c09', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 0, '2025-12-06 03:18:24.194579', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('80523df0-ef22-409f-bbab-a24dd84ed38e', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 1, '2025-12-06 03:18:24.761912', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('10e49843-8637-4f56-a4b1-085bc9fd9cc3', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 0, '2025-12-06 03:18:24.770642', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3f16f245-9e41-4447-ac1d-6a1072a5dda7', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 1, '2025-12-06 03:18:25.266532', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('69c12501-fc6d-4dff-8bd0-34c440617dbf', 'ca6789af-a398-4263-919b-026439df484b', '+33687675235', NULL, NULL, 0, '2025-12-06 03:18:25.276821', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('da5a16fa-256e-44e8-a725-1d9e541bb215', 'ca6789af-a398-4263-919b-026439df484b', '+33687675235', NULL, NULL, 1, '2025-12-06 03:18:25.587689', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('aa2911be-c838-4312-8a6c-fdae1c762f18', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 0, '2025-12-06 03:18:25.59815', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('90f85de9-eb02-4724-907b-7dc8339d6362', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 1, '2025-12-06 03:18:25.93538', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('92c568ea-5857-471e-bd49-fc54033289af', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', NULL, NULL, 0, '2025-12-06 03:18:25.943809', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('51cd65ad-4186-4ffa-963b-351b2bb51e63', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', NULL, NULL, 1, '2025-12-06 03:18:26.235539', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('161d9e01-d108-485c-a75d-215ff7fad9f8', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', NULL, NULL, 0, '2025-12-06 03:18:26.246555', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3318879d-a601-447b-b4d5-16e5bdacaeaa', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', NULL, NULL, 1, '2025-12-06 03:18:26.792762', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0ffff47b-466e-4140-9810-211f32fdd0bf', 'a543bbd8-04ae-4074-bc43-10de8c0aba69', '+33661868329', NULL, NULL, 0, '2025-12-06 03:18:26.801366', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('eb4214dd-e588-424d-975f-84e92b877792', 'a543bbd8-04ae-4074-bc43-10de8c0aba69', '+33661868329', NULL, NULL, 1, '2025-12-06 03:18:27.091346', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d2368e67-c10f-445c-a5ef-9b5e4b73f247', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', NULL, NULL, 0, '2025-12-06 03:18:27.099484', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ff1ac155-9229-4167-8f2b-a19d7dcc18ff', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', NULL, NULL, 1, '2025-12-06 03:18:27.412047', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('ede581af-2db4-4f0c-af7f-978529a72056', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 0, '2025-12-06 03:18:27.422268', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e7bf051d-b516-401d-b694-a54121a843da', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 1, '2025-12-06 03:18:27.727346', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('33191cd5-e62b-4f13-856e-813576f3498e', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', NULL, NULL, 0, '2025-12-06 03:18:27.736707', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('38062da3-697f-414c-83bf-1baee09cdf85', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', NULL, NULL, 1, '2025-12-06 03:18:28.018048', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('ffcb9dac-5e71-4a69-b1e8-f26a153ba2ec', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 0, '2025-12-06 03:18:28.027196', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1bdb7ce3-9eb1-4808-89a6-2a4b1ed82648', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 1, '2025-12-06 03:18:28.338727', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('b261d098-7abf-4406-aba5-3257807432f7', '86834cac-f4fc-44a1-b536-f3d38643c835', '+33664538190', NULL, NULL, 0, '2025-12-06 03:18:28.346396', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('36f3650e-b70a-4428-a5e8-8ff1f40bad1b', '86834cac-f4fc-44a1-b536-f3d38643c835', '+33664538190', NULL, NULL, 1, '2025-12-06 03:18:28.646961', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('829e8154-b2fc-4e54-b446-6a950f59e993', '0840c04c-05c0-45f8-ab6c-e2778a3b3744', '+33634277641', NULL, NULL, 0, '2025-12-06 03:18:28.659981', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3e473151-0a4c-4c65-a0ac-eabe568f4862', '0840c04c-05c0-45f8-ab6c-e2778a3b3744', '+33634277641', NULL, NULL, 1, '2025-12-06 03:18:29.194837', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('b4c7c0e1-2fe6-47d2-8819-c71b46500866', '3af6f2b8-1760-4d5c-b08c-7e100d33335d', '+33771271612', NULL, NULL, 0, '2025-12-06 03:18:29.203891', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c1218060-af3e-482f-b16a-bccec5218079', '3af6f2b8-1760-4d5c-b08c-7e100d33335d', '+33771271612', NULL, NULL, 1, '2025-12-06 03:18:29.48666', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a1f3424a-53cb-4a1f-9fef-9687c7b99e51', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 0, '2025-12-06 03:18:29.499062', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('102a6ad4-b7ab-4dea-95ae-40777cdf1c3b', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 1, '2025-12-06 03:18:30.031938', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('21a80042-4ee6-4b84-a173-1c8d8f00ecf6', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, NULL, 0, '2025-12-06 03:18:30.044101', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a6f2529f-1afa-44be-98ac-ff88e97d5dde', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, NULL, 1, '2025-12-06 03:18:30.352695', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('cbdbd3b7-c33c-48c4-97a6-facd973350ef', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', NULL, NULL, 0, '2025-12-06 03:18:30.361816', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('7c83840a-99ab-4827-8680-1edb87ce4ee0', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', NULL, NULL, 1, '2025-12-06 03:18:30.673327', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('1f6e91f8-d2de-48ea-af1d-2d3f5934b984', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 0, '2025-12-06 03:18:30.683783', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1499b988-ef59-4982-aa44-4e41ad2d6abf', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 1, '2025-12-06 03:18:31.192565', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d8c2c801-4cfe-47d1-86e5-539a0cd44f00', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', NULL, NULL, 0, '2025-12-06 03:18:31.202336', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('caf72cdf-f541-4cb2-9d6d-aaf1e3c91eb6', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', NULL, NULL, 1, '2025-12-06 03:18:31.49781', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('571b5738-09f6-4830-a3e7-6631e7c5dc07', '06f72afb-571c-470a-9d04-ca83edc9010f', '+33662353483', NULL, NULL, 0, '2025-12-06 03:46:23.152291', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ba3c45b6-cbed-46e3-9f83-d7b4814d2163', '06f72afb-571c-470a-9d04-ca83edc9010f', '+33662353483', NULL, NULL, 1, '2025-12-06 03:46:23.4512', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('64a84060-c64c-4ddb-ac92-758d201731de', 'a43cce16-e1d6-4c13-b440-0499a81de6f2', '+33663787744', NULL, NULL, 0, '2025-12-06 03:46:23.45721', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3fc43b96-236d-499a-bce0-87fe99b0c77b', 'a43cce16-e1d6-4c13-b440-0499a81de6f2', '+33663787744', NULL, NULL, 1, '2025-12-06 03:46:23.957204', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bebbaa2a-6a59-48fe-b535-a2fe408b58ed', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', NULL, NULL, 0, '2025-12-06 03:46:23.963151', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('35f9680c-6a96-475a-9101-a43e3f769487', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', NULL, NULL, 1, '2025-12-06 03:46:24.464113', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('184ad48b-ed18-4e5d-b848-91c7bb25a0b7', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 0, '2025-12-06 03:46:24.470089', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('57f2347b-03ca-4985-a76f-89d5cd4abc42', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 1, '2025-12-06 03:46:24.978264', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5f248514-4f75-4e55-9074-c9a71c4997e0', '9f874782-653f-4272-b659-090ed53cb7f9', '+33783064624', NULL, NULL, 0, '2025-12-06 03:46:24.983455', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('abdf6a94-3118-4274-989a-268f50e0fd93', '9f874782-653f-4272-b659-090ed53cb7f9', '+33783064624', NULL, NULL, 1, '2025-12-06 03:46:25.291585', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7cff8198-5b37-4c5d-834b-c5160184772e', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', NULL, NULL, 0, '2025-12-06 03:46:25.296109', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('48b1752d-65a0-4803-b7d9-f647173e4b5e', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', NULL, NULL, 1, '2025-12-06 03:46:25.791336', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7aabf32f-16b2-4320-91d5-818be067d5be', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', NULL, NULL, 0, '2025-12-06 03:46:25.796731', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d772f0c7-4de0-478f-9064-1dac1c8642f9', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', NULL, NULL, 1, '2025-12-06 03:46:26.099127', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('26cc20e2-fb70-43ac-8f49-be9ba32dc200', '1599f73a-81e9-4a1e-8dbf-181773065bd7', '+33687346570', NULL, NULL, 0, '2025-12-06 03:46:26.10312', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('4438818d-e77f-453d-b22f-b1f99ac6377b', '1599f73a-81e9-4a1e-8dbf-181773065bd7', '+33687346570', NULL, NULL, 1, '2025-12-06 03:46:26.605968', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('36c56761-d3e6-4843-93a6-7db5856666c9', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', NULL, NULL, 0, '2025-12-06 03:46:26.611644', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a1ddd008-0f7a-4833-82d2-a876e777c567', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', NULL, NULL, 1, '2025-12-06 03:46:26.916564', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('46ff8a2f-9c82-4f7e-8ece-045c3ccd45c7', '91af7307-0c46-4276-8349-de60962d0017', '+33786020489', NULL, NULL, 0, '2025-12-06 03:46:26.921052', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1db9dd1c-972c-4e98-87f6-f8d8f200ec8e', '91af7307-0c46-4276-8349-de60962d0017', '+33786020489', NULL, NULL, 1, '2025-12-06 03:46:27.433345', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7f6ebad2-e684-49ab-a9e5-b7ba8407711d', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', NULL, NULL, 0, '2025-12-06 03:46:27.439326', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('83dffa59-566d-4236-bb06-6d8b20c30d66', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', NULL, NULL, 1, '2025-12-06 03:46:27.945433', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('2f6a5b9d-556e-477f-82f1-ca13ced332d1', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 0, '2025-12-06 03:46:27.951241', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('6b5687bf-b7c2-4b84-a0a9-2f9951b967d9', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 1, '2025-12-06 03:46:28.243102', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('1da045ec-132d-43de-a025-3d1f29937c19', 'bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', '+33681432541', NULL, NULL, 0, '2025-12-06 03:46:28.247949', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('0e275a11-1b73-4e34-a72a-078d040b5b45', 'bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', '+33681432541', NULL, NULL, 1, '2025-12-06 03:46:28.917953', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('01b1a330-b297-4856-b661-a7ccb67b2c48', 'aa585d61-6ec4-4be2-b637-b0cb16a830cb', '+33679159125', NULL, NULL, 0, '2025-12-06 03:46:28.923276', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('31ed3db1-abbb-4e11-a0ea-a73864aa1278', 'aa585d61-6ec4-4be2-b637-b0cb16a830cb', '+33679159125', NULL, NULL, 1, '2025-12-06 03:46:29.396927', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('214e03ac-33ae-442f-9625-1a14bdcb488a', 'a2e94284-c225-4063-8447-11175e49f030', '+33647787728', NULL, NULL, 0, '2025-12-06 03:46:29.401061', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5861f691-0f41-41fb-88c4-e2cbb91779fb', 'a2e94284-c225-4063-8447-11175e49f030', '+33647787728', NULL, NULL, 1, '2025-12-06 03:46:29.896186', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d2bcca86-283a-4e0f-9b17-835a278a7aa9', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 0, '2025-12-06 03:46:29.900889', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b3caf770-2ea0-42ab-9955-a64033996b5c', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 1, '2025-12-06 03:46:30.193429', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('ecba573e-f57e-4875-a454-26ebcafa6145', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', NULL, NULL, 0, '2025-12-06 03:46:30.198337', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('58f3ea93-048c-4c46-88db-81fa57039946', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', NULL, NULL, 1, '2025-12-06 03:46:30.484497', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('8c06e10e-9af3-4563-be3d-19dd0111764e', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', NULL, NULL, 0, '2025-12-06 03:46:30.495723', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('608b8ffb-92e4-440a-92f9-8257d09e72b4', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', NULL, NULL, 1, '2025-12-06 03:46:30.80186', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('abd42e83-a684-4e5c-9621-80704d814749', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33615434343', NULL, NULL, 0, '2025-12-06 03:46:30.808383', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3628d0f2-f15e-47f1-bd8f-ee27a3e3dfbf', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33615434343', NULL, NULL, 1, '2025-12-06 03:46:31.338099', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('58f68eb3-4e5d-4443-a384-9b4302d24a83', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 0, '2025-12-06 03:46:31.343335', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e59e087a-8ce2-4057-a0d7-74cda6b480f1', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 1, '2025-12-06 03:46:31.639954', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5112bb46-1044-4bc9-86bc-0dcac269e001', '22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', '+33608035361', NULL, NULL, 0, '2025-12-06 03:46:31.645006', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e78b75e4-1df3-4766-a1f8-0fbb04091ccf', '22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', '+33608035361', NULL, NULL, 1, '2025-12-06 03:46:31.949635', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e3b02516-4750-46b2-9299-c295b9125b7d', 'e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', '+33607430571', NULL, NULL, 0, '2025-12-06 03:46:31.954981', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b9a6d3f4-a219-40bb-ad53-6a5e78efc072', 'e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', '+33607430571', NULL, NULL, 1, '2025-12-06 03:46:32.45313', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('64e25d1d-8fcf-42f6-a60f-8c0bc757d377', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', NULL, NULL, 0, '2025-12-06 03:46:32.459247', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('219c3620-5553-4da1-97e6-e9a307ff9ec6', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', NULL, NULL, 1, '2025-12-06 03:46:32.960978', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a2e98111-0819-49c6-a5e1-51a0e94977ac', 'c76145f4-3bbe-420a-9873-1410b3b7aff4', '+33670667723', NULL, NULL, 0, '2025-12-06 03:46:32.966523', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('40f6f795-1ef0-4531-8e54-24d8cc71d71a', 'c76145f4-3bbe-420a-9873-1410b3b7aff4', '+33670667723', NULL, NULL, 1, '2025-12-06 03:46:33.272188', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('38fe55f2-6431-470a-b3e5-a62cb47ad579', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', NULL, NULL, 0, '2025-12-06 03:46:33.278241', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('7e762599-5363-41ff-9c08-d95e1ddf12c2', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', NULL, NULL, 1, '2025-12-06 03:46:33.767965', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a4755964-b46f-4be2-8b49-ca46b837eeb9', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', NULL, NULL, 0, '2025-12-06 03:46:33.773772', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('77137241-6201-4a7d-9ec4-30dfc985c25b', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', NULL, NULL, 1, '2025-12-06 03:46:34.080695', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7bc65e70-0640-4c49-ba6e-1e36b8af55e4', 'f570075c-a0f6-4f85-9697-4a313d73bcde', '+33661249828', NULL, NULL, 0, '2025-12-06 03:46:34.086169', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('365ba7a7-92e7-454c-b794-8659e0f4f9fb', 'f570075c-a0f6-4f85-9697-4a313d73bcde', '+33661249828', NULL, NULL, 1, '2025-12-06 03:46:34.76205', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('750771e7-2a26-424a-bccf-92aa7bf50ac1', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', NULL, NULL, 0, '2025-12-06 03:46:34.767873', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('81a01a61-5a3a-4f51-9d08-374a0a3fed05', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', NULL, NULL, 1, '2025-12-06 03:46:35.083597', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0d19b841-9a28-4917-9805-cdaf1ad1e701', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, NULL, 0, '2025-12-06 03:46:35.090141', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('54201063-6557-4e17-8e01-f0f3570a311d', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, NULL, 1, '2025-12-06 03:46:35.392532', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('72c5b985-485e-40f0-9679-bc94cabefc18', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 0, '2025-12-06 03:46:35.397316', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('bb4c92e5-01ff-4203-aec1-0aaa6ba8cf6c', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 1, '2025-12-06 03:46:35.90181', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('f270a3aa-6950-47cd-9992-02ed0bb9b521', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', NULL, NULL, 0, '2025-12-06 03:46:35.906975', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5e9c9d57-57f5-479a-8a6b-95ab171ff6f2', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', NULL, NULL, 1, '2025-12-06 03:46:36.373888', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e9c301e4-c30a-4626-bf95-a6f5af8d5df2', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', NULL, NULL, 0, '2025-12-06 03:46:36.379763', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1ad3d4ff-1eb7-40ca-b754-3410a0ce23d9', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', NULL, NULL, 1, '2025-12-06 03:46:36.879738', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('8bf6c7a4-7a68-4658-b1f0-01e75a3ef52a', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', NULL, NULL, 0, '2025-12-06 03:46:36.884898', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('2204b7e6-671f-4299-be24-c19c6b4dae16', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', NULL, NULL, 1, '2025-12-06 03:46:37.374049', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7e954bfa-a723-438c-a18f-203573f31fd5', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 0, '2025-12-06 03:46:37.378481', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e767d3b8-afd6-48b5-aad9-311d0972a9f4', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 1, '2025-12-06 03:46:37.878474', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('3b3913cf-69d1-4961-a189-ce1fa7d5c096', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 0, '2025-12-06 03:46:37.884217', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('dc6db3b5-ff68-4bce-ab39-df69e0461c81', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 1, '2025-12-06 03:46:38.220516', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('37e50cb7-73aa-4b60-9a15-7416f0309184', '92470fa0-c720-47d4-94a1-ce68637c18b3', '+33614392050', NULL, NULL, 0, '2025-12-06 03:46:38.225084', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('7507a756-6c01-493d-9788-615b19055644', '92470fa0-c720-47d4-94a1-ce68637c18b3', '+33614392050', NULL, NULL, 1, '2025-12-06 03:46:38.52779', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('965375d3-4f8d-4bc7-960c-76281f3a5832', '16271680-19a8-4184-a754-337364221875', '+33673426632', NULL, NULL, 0, '2025-12-06 03:46:38.532996', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('60f2f34e-0ba4-4c3f-890c-673487daef8e', '16271680-19a8-4184-a754-337364221875', '+33673426632', NULL, NULL, 1, '2025-12-06 03:46:38.843069', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('97f3c19b-be36-482b-9e31-b41ac2a9acfe', '5a67bbe0-58e7-4d63-98e8-433df60e7e1d', '+33659706203', NULL, NULL, 0, '2025-12-06 03:46:38.849547', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('f3f1a77b-45ed-4b32-92c9-6bf4b276de70', '5a67bbe0-58e7-4d63-98e8-433df60e7e1d', '+33659706203', NULL, NULL, 1, '2025-12-06 03:46:39.142851', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a949df17-09f8-4abd-ae95-ab62da037cce', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 0, '2025-12-06 03:46:39.148096', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('15af60ed-1598-40e5-98f7-a4ecceb207c2', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 1, '2025-12-06 03:46:39.648356', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('6533cabb-fb7c-4977-9da4-8cd76aed6436', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 0, '2025-12-06 03:46:39.652812', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b498efcb-95f2-4148-befa-3b925bdb93a9', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 1, '2025-12-06 03:46:39.979132', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('8f1da518-4893-45ff-8db2-4ee35c7b44a6', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 0, '2025-12-06 03:46:39.98385', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5de49025-12c0-4fb5-ab3b-31514aa4d102', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 1, '2025-12-06 03:46:40.28665', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e326dd36-978f-41ed-b58b-17127ba87dfd', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 0, '2025-12-06 03:46:40.29188', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('06dcf4b2-d447-4600-b595-f4ca528253fb', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 1, '2025-12-06 03:46:40.598882', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('714181f0-c4b7-48eb-a0ea-8e420c973754', '84aba313-5d27-48c0-96a6-6f99441becc5', '+33632764948', NULL, NULL, 0, '2025-12-06 03:46:40.60516', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d7a96872-bea5-4e3b-b5dd-4029ed64b5bc', '84aba313-5d27-48c0-96a6-6f99441becc5', '+33632764948', NULL, NULL, 1, '2025-12-06 03:46:40.886784', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('25ac479d-a3ce-4abf-a0ac-e52784d33565', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', NULL, NULL, 0, '2025-12-06 03:46:40.891266', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a84cc3f0-4b33-4b78-bf26-775fd7ca5d03', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', NULL, NULL, 1, '2025-12-06 03:46:41.19932', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e0f17493-2d13-46af-981a-98f925b11b0b', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 0, '2025-12-06 03:46:41.205183', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('cba6ae31-00f2-4064-818a-d69fa8ce96a5', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 1, '2025-12-06 03:46:41.50329', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5966b0f3-7493-4fac-851f-e2ac71463be0', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 0, '2025-12-06 03:46:41.508012', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('4f3b4c68-e63a-4be9-8243-9dad4ba0d52a', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 1, '2025-12-06 03:46:41.99602', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('66f4497a-924e-45b2-83d3-a3d90ad17f06', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 0, '2025-12-06 03:46:42.000972', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('acd7ae5a-cf0c-4e23-b859-ec410d810c6f', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 1, '2025-12-06 03:46:42.502113', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('ff3ce64b-848d-4f7a-aec8-0f28e367d808', 'c013befe-a972-44be-86de-7996756f4402', '+33777073500', NULL, NULL, 0, '2025-12-06 03:46:42.507514', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('6346bc29-5265-47d4-a0eb-f98f81c0da88', 'c013befe-a972-44be-86de-7996756f4402', '+33777073500', NULL, NULL, 1, '2025-12-06 03:46:42.825326', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('e7878686-c8c8-4b21-a9ce-b8a085b145cb', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 0, '2025-12-06 03:46:42.831585', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('9da497bb-df5c-4f27-bd09-c16d7868004b', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 1, '2025-12-06 03:46:43.13086', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5cb9d4f7-b5b4-4256-9efe-a0aa26c74c7a', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 0, '2025-12-06 03:46:43.135442', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b032ac8e-1c0a-46e4-aba7-29e08c8c0d3a', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 1, '2025-12-06 03:46:43.433742', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('67782638-4b78-4af3-ac95-ae1e0cc74789', '8d141563-9b62-4b6d-a7c6-b7851d63a519', '+33687450613', NULL, NULL, 0, '2025-12-06 03:46:43.440707', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5846ec91-9a95-43c1-b0ec-6fa85ca217a3', '8d141563-9b62-4b6d-a7c6-b7851d63a519', '+33687450613', NULL, NULL, 1, '2025-12-06 03:46:43.719821', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('f7d56b2a-cc69-4d6e-843e-12d72da4f57f', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', NULL, NULL, 0, '2025-12-06 03:46:43.728152', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('4f84e65e-9a3e-4401-86dc-6ea663ba0b0a', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', NULL, NULL, 1, '2025-12-06 03:46:44.413514', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0748c1ec-1adc-4647-b3a0-0730534aa2cb', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', NULL, NULL, 0, '2025-12-06 03:46:44.419022', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('51b8f5e5-aad2-4eab-88ea-5555c25f495c', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', NULL, NULL, 1, '2025-12-06 03:46:44.712474', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('18e199fe-f9cb-4135-813b-6f7b5616efa9', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', NULL, NULL, 0, '2025-12-06 03:46:44.717646', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('7c3fa557-fa05-4150-b003-7033c6515579', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', NULL, NULL, 1, '2025-12-06 03:46:45.024692', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('34e0f1a7-4257-4597-a417-51a2dd63f4dd', '2cd0c3ac-b710-4f8a-8791-33eab9142483', '+33610220533', NULL, NULL, 0, '2025-12-06 03:46:45.030142', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('592df141-4777-45e9-947f-38f8a45e7f83', '2cd0c3ac-b710-4f8a-8791-33eab9142483', '+33610220533', NULL, NULL, 1, '2025-12-06 03:46:45.32788', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0624617e-9d9b-4357-8cbb-0b0e0246bc74', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 0, '2025-12-06 03:46:45.335984', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('97bf548f-4fd3-44e4-9774-0cce71cc184d', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 1, '2025-12-06 03:46:45.627488', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('1a785238-1fb0-4571-a041-c1486590308e', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 0, '2025-12-06 03:46:45.632344', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('2d694ce4-c045-42a6-80ef-ce8d93f5a58f', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 1, '2025-12-06 03:46:45.911468', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('57232085-c536-4283-be13-390e84493d02', '5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', '+33699047451', NULL, NULL, 0, '2025-12-06 03:46:45.918953', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3001b0f0-9986-48e2-982a-6842be1917bc', '5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', '+33699047451', NULL, NULL, 1, '2025-12-06 03:46:46.226', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('2e113cef-e713-486b-a0f1-a9163d2a50b8', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 0, '2025-12-06 03:46:46.232155', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e04b2a6f-e8b8-418e-a9f4-a9cb0154c7fe', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 1, '2025-12-06 03:46:46.718355', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a083b5b7-1c7a-4a68-83be-77b4f98125ba', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', NULL, NULL, 0, '2025-12-06 03:46:46.723973', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d33d1014-93ae-4990-ae74-764d739ead0c', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', NULL, NULL, 1, '2025-12-06 03:46:47.004977', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('40877c28-170a-4048-9725-de38a8dc00c1', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', NULL, NULL, 0, '2025-12-06 03:46:47.058373', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3b30fd8f-6018-465c-bcc5-86b5482ddd46', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', NULL, NULL, 1, '2025-12-06 03:46:47.39109', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('4e1afcd0-feeb-4ff9-90f7-60f7d8ef9bcf', '0d5eb5c0-b6ad-4900-80d4-24b70bdb2494', NULL, NULL, NULL, 4, '2025-12-06 03:46:47.396776', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8734f918-1a61-4d20-a05c-8089460b16b1', 'fc81bc18-e7af-4e11-a3b7-48c02b2ca2c0', NULL, NULL, NULL, 4, '2025-12-06 03:46:47.40139', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d95fc90a-ffff-4c61-b489-65707b63265d', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 0, '2025-12-06 03:46:47.405107', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ab031a60-5d63-41d0-aba2-ae4f064ab154', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 1, '2025-12-06 03:46:47.866757', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('3e8415b1-eee0-44ae-9b20-bcb39b6d5895', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 0, '2025-12-06 03:46:47.871411', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('3c980f7c-116f-43f9-9dc8-c4a77127ae0b', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 1, '2025-12-06 03:46:48.186626', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('1658e8bb-2ee4-41f8-b986-2a132d22570e', '24777749-e3ab-49c7-9bcb-82127cf86474', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.191016', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('dcfaecb8-21b6-4fd7-8489-f932775247c8', 'b54716dd-d3d6-45d2-9534-e8a338656f1f', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.194611', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('2ed6a68b-8cd4-42e0-820a-fe5ea7e3abb7', '53f49bd7-41bb-44b9-bdee-e975bdcd062f', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.198675', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5279756c-718b-475e-b636-61dd38370966', 'b9c5ea85-b37e-4fc5-96a3-5fe2dbd9cb09', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.202574', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c2946844-3810-4b55-bd2a-cea5d0e0643c', '6286226d-398a-44d6-b94a-eb614707bf93', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.206448', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('fd3ba5b9-aad5-4368-b29e-9c5db54289e6', 'cb5b702b-6e9a-49e3-b594-e01b88504fe5', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.210408', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('06c7ab1e-14ba-48ad-a0b6-40168dded438', '05c6e24d-7094-4602-a429-d30dcb004a9f', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.214087', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a2455331-bfb1-47a2-b4b4-4d078eae93b5', '33f42380-fc0d-48d0-ad9a-d962600fe2bc', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.219576', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c68e9167-951b-428d-8ee4-dafa94f2dcf3', '4641ff7e-36de-4767-8123-5efde5e01f39', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.225327', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8286ef62-0924-44d8-b6a4-237873bc545c', '1dd7af56-8dd9-451f-9b14-ce03441f8589', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.237062', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('44b8778e-6c87-4556-b02b-b195e88114bf', '15f0cced-441a-40bb-bf61-00d086363946', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.246437', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8027e9d3-7a7b-43be-afcd-a387a304004a', 'ff95a114-a898-47f4-bfaf-bf3b79ee1f6e', NULL, NULL, NULL, 4, '2025-12-06 03:46:48.252864', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('a864382b-0bbd-4c20-9a17-51deaff3303b', 'f3087033-2aaf-4c80-b2b6-2706bf5d2f09', '+33610961982', NULL, NULL, 0, '2025-12-06 03:46:48.258805', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1f8a25f2-8ce4-4d53-bb4e-e093b73a26f3', 'f3087033-2aaf-4c80-b2b6-2706bf5d2f09', '+33610961982', NULL, NULL, 1, '2025-12-06 03:46:48.553788', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('a64cb840-a1a9-4973-8b19-f5ea5b34f149', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', NULL, NULL, 0, '2025-12-06 03:46:48.558237', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b0d1999f-bb65-406e-959c-bde2176cf300', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', NULL, NULL, 1, '2025-12-06 03:46:49.038651', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bf1c181c-aa48-42ff-b01f-a0fb7d975f9f', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 0, '2025-12-06 03:46:49.043348', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('e96e4cd3-a21c-43ab-a2c4-f5b8df4ec08c', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 1, '2025-12-06 03:46:49.541941', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('1b5e82cb-b2d3-438c-99e1-a1d618cd1725', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', NULL, NULL, 0, '2025-12-06 03:46:49.547048', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('9d72c935-13cf-4591-a15f-ca845c9e61b3', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', NULL, NULL, 1, '2025-12-06 03:46:49.846179', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0a5364a3-ba3a-47f2-94aa-1d42b90e30fc', '638e9607-ce5d-465d-b39f-1671ee6dff09', '+33612400854', NULL, NULL, 0, '2025-12-06 03:46:49.853051', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('95f2491f-f449-46c6-a7ac-e64e03a26ae0', '638e9607-ce5d-465d-b39f-1671ee6dff09', '+33612400854', NULL, NULL, 1, '2025-12-06 03:46:50.139465', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('5fed6c5f-2729-4f07-af53-9b98e725b0f2', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 0, '2025-12-06 03:46:50.148823', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('30656aab-c6b3-488e-ae6e-2aca0e6feea8', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 1, '2025-12-06 03:46:50.63739', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('d2600563-ad09-48ae-b239-92c645eafe7d', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 0, '2025-12-06 03:46:50.641997', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('8a7af000-9f25-480f-a297-2cf70d1c829b', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 1, '2025-12-06 03:46:50.929924', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('09f3bf2c-e388-4da6-9b9b-ba379ba64b46', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 0, '2025-12-06 03:46:50.934478', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('7f6ca2d9-df64-44c9-ad7f-64dfe9b43e8a', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 1, '2025-12-06 03:46:51.230323', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('7d4b43f3-5cf7-4640-9ff4-24023d97f02f', '2cd0c3ac-b710-4f8a-8791-33eab9142483', '+33610220533', 'pierre.trautmann67@gmail.com', '1972-05-24', 1, '2025-12-06 03:51:03.812056', 1, 'Pierre Trautmann', 'Mise à jour des informations du contact'),
	('e3de8746-33c4-4ca2-bfa1-01759006e4f5', '2cd0c3ac-b710-4f8a-8791-33eab9142483', '+33610220533', 'pierre.trautmann67@gmail.com', '1972-05-24', 2, '2025-12-06 03:51:03.812872', 1, 'Pierre Trautmann', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('58306abf-8525-4ae4-9d92-87e2d98da974', '638e9607-ce5d-465d-b39f-1671ee6dff09', '+33612400854', 'gillesfiege@gmail.com', '1981-08-07', 1, '2025-12-06 04:12:11.04908', 1, 'Gilles Fiege', 'Mise à jour des informations du contact'),
	('fed72fa9-6d6b-4052-be97-f45029ebd7cf', '638e9607-ce5d-465d-b39f-1671ee6dff09', '+33612400854', 'gillesfiege@gmail.com', '1981-08-07', 2, '2025-12-06 04:12:11.049834', 1, 'Gilles Fiege', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ea3feb28-94b0-47b8-9fc3-fbe65cacfe0f', '84aba313-5d27-48c0-96a6-6f99441becc5', '+33632764948', 'thierry.debargue@gmail.com', '1975-02-14', 1, '2025-12-06 04:59:05.834691', 1, 'Thierry Debargue', 'Mise à jour des informations du contact'),
	('08d69a0b-351e-491e-a47e-360cb27c219a', '84aba313-5d27-48c0-96a6-6f99441becc5', '+33632764948', 'thierry.debargue@gmail.com', '1975-02-14', 2, '2025-12-06 04:59:05.836293', 1, 'Thierry Debargue', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('31683cd0-a6be-482a-b5f0-a920bd79ae84', '5a67bbe0-58e7-4d63-98e8-433df60e7e1d', '+33659706203', NULL, NULL, 2, '2025-12-06 05:18:54.529274', 1, 'Pierre-alban Karli', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('85f8fb56-ca6b-4f4d-ab8f-366046dd1ed9', '87526c43-8507-450c-b315-f2b6ed5d4833', '+33619739111', 'marie.chaventon@yahoo.fr', '1990-06-22', 1, '2025-12-06 06:20:54.578944', 1, 'Marie Chaventon', 'Mise à jour des informations du contact'),
	('c0ce01c5-0820-4c63-957d-2cd53828ea78', '87526c43-8507-450c-b315-f2b6ed5d4833', '+33619739111', 'marie.chaventon@yahoo.fr', '1990-06-22', 2, '2025-12-06 06:20:54.579543', 1, 'Marie Chaventon', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d4bb3a45-f767-472a-ac7e-3866e906f112', 'f468aa64-a23c-4aab-a66b-c21eaeddb403', '+33602035797', 'audrey.thomas67@icloud.com', '1980-10-16', 1, '2025-12-06 06:23:11.27925', 1, 'Audrey Thomas', 'Mise à jour des informations du contact'),
	('3f09197b-3e31-441d-ae44-1d1131e53080', 'f468aa64-a23c-4aab-a66b-c21eaeddb403', '+33602035797', 'audrey.thomas67@icloud.com', '1980-10-16', 2, '2025-12-06 06:23:11.280855', 1, 'Audrey Thomas', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('7de27678-e3b5-489b-9692-2d4f0d9590dd', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', 'tcolnot2@gmail.com', '1970-08-09', 1, '2025-12-06 06:27:57.278683', 1, 'Thierry Colnot', 'Mise à jour des informations du contact'),
	('91929503-6672-41c0-8062-76c4cb8132bc', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', 'tcolnot2@gmail.com', '1970-08-09', 2, '2025-12-06 06:27:57.279278', 1, 'Thierry Colnot', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('b3c9d197-06ee-4b8b-80d8-1c8e3114e29e', '92470fa0-c720-47d4-94a1-ce68637c18b3', '+33614392050', 'ashshand.philippe@orange.fr', '1959-05-11', 1, '2025-12-06 06:32:20.649193', 1, 'Philippe Thomas', 'Mise à jour des informations du contact'),
	('169257ec-8486-4ffc-aeac-3a0273199e18', '92470fa0-c720-47d4-94a1-ce68637c18b3', '+33614392050', 'ashshand.philippe@orange.fr', '1959-05-11', 2, '2025-12-06 06:32:20.650178', 1, 'Philippe Thomas', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1437ea38-1a24-4dac-9dea-391dadfc3d17', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', 'michael.hauler@gmail.com', NULL, 1, '2025-12-06 06:53:04.007136', 1, 'Michael Hauler', 'Mise à jour des informations du contact'),
	('b4220be3-d912-463a-ae61-b1e5cc31cf45', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', 'michael.hauler@gmail.com', NULL, 2, '2025-12-06 06:53:04.007831', 1, 'Michael Hauler', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c9aef022-3f96-4c67-bfa4-d9dc90bdd478', 'a43cce16-e1d6-4c13-b440-0499a81de6f2', '+33663787744', NULL, '1975-01-01', 1, '2025-12-06 07:02:14.922658', 1, 'Mathieu Blanchard', 'Mise à jour des informations du contact'),
	('5cc17cb7-8268-451c-a054-c6cfa05d2770', 'a43cce16-e1d6-4c13-b440-0499a81de6f2', '+33663787744', NULL, '1975-01-01', 2, '2025-12-06 07:02:14.923605', 1, 'Mathieu Blanchard', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1f1a7670-bcb2-4afa-8f0b-9ee2a22f7611', 'c013befe-a972-44be-86de-7996756f4402', '+33777073500', 'berzug@yahoo.fr', '1975-03-29', 1, '2025-12-06 07:09:48.234047', 1, 'Bertrand ZUGMEYER', 'Mise à jour des informations du contact'),
	('7dae8e3f-c700-4a24-ab08-ed0d026114cc', 'c013befe-a972-44be-86de-7996756f4402', '+33777073500', 'berzug@yahoo.fr', '1975-03-29', 2, '2025-12-06 07:09:48.234549', 1, 'Bertrand ZUGMEYER', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('a2aeda76-90f0-4587-b6eb-3d9d9f3a3472', '86834cac-f4fc-44a1-b536-f3d38643c835', '+33664538190', 'nelaespa@gmail.com', '1960-04-14', 1, '2025-12-06 07:20:21.949771', 1, 'Nelida Garcia', 'Mise à jour des informations du contact'),
	('765ece28-e6e9-4514-af0f-da0dd94dfe15', '86834cac-f4fc-44a1-b536-f3d38643c835', '+33664538190', 'nelaespa@gmail.com', '1960-04-14', 2, '2025-12-06 07:20:21.95041', 1, 'Nelida Garcia', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('74288f34-5711-4811-8e0a-54588c4cf51e', 'f3087033-2aaf-4c80-b2b6-2706bf5d2f09', '+33610961982', 'francois.gless@hotmail.com', '1987-12-26', 1, '2025-12-06 07:21:43.316881', 1, 'François Gless', 'Mise à jour des informations du contact'),
	('be64da91-851c-4335-9e60-2f6702a95cbd', 'f3087033-2aaf-4c80-b2b6-2706bf5d2f09', '+33610961982', 'francois.gless@hotmail.com', '1987-12-26', 2, '2025-12-06 07:21:43.317324', 1, 'François Gless', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c5ea5de4-ed4a-4329-98fa-9984f56f3c83', 'e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', '+33607430571', NULL, '1984-01-04', 1, '2025-12-06 07:32:58.402598', 1, 'Jérome Fritsch', 'Mise à jour des informations du contact'),
	('0138ea71-b806-460b-b8b8-76a10ee8ca5a', 'e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', '+33607430571', NULL, '1984-01-04', 2, '2025-12-06 07:32:58.404994', 1, 'Jérome Fritsch', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('039f1e38-ead6-4418-a81c-9e8e53fa2c5b', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 0, '2025-12-06 07:35:12.223109', 0, 'Anonyme', 'Enregistrement initial'),
	('b1801592-c9db-447b-aae7-5f9fb81180af', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', 'my.tu1988@outlook.fr', '1988-07-22', 1, '2025-12-06 07:37:19.141488', 1, 'My Duyen Tu', 'Mise à jour des informations du contact'),
	('fb6991dd-3e45-4733-b275-d5112fc83324', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', 'my.tu1988@outlook.fr', '1988-07-22', 2, '2025-12-06 07:37:19.142028', 1, 'My Duyen Tu', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('73486d73-e82f-49da-8526-db7fc3a2d202', '0840c04c-05c0-45f8-ab6c-e2778a3b3744', '+33634277641', 'ottceline81@gmail.com', '1981-03-24', 1, '2025-12-06 07:42:28.938889', 1, 'Celine Wolff (Ott)', 'Mise à jour des informations du contact'),
	('9f807dce-1003-4c2d-8bf9-54cf3f62b41e', '0840c04c-05c0-45f8-ab6c-e2778a3b3744', '+33634277641', 'ottceline81@gmail.com', '1981-03-24', 2, '2025-12-06 07:42:28.939495', 1, 'Celine Wolff (Ott)', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('57925979-7fb3-4738-9c10-360a4750cf57', '9913046a-680a-42fc-8c33-1c7cc517aeef', '+33659200650', NULL, NULL, 0, '2025-12-06 07:42:39.753126', 0, 'My-Duyen TU', 'Enregistrement initial'),
	('08e3c9c2-a0e3-4303-819c-7756de7eabb2', '9913046a-680a-42fc-8c33-1c7cc517aeef', '+33659200650', NULL, NULL, 1, '2025-12-06 07:42:40.38082', 1, 'My-Duyen TU', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bf5b1dce-4124-4d0d-9cf1-412626647f0d', '319de8c0-be99-4210-9ecc-ba43c0c7e382', '+33607827250', 'eric.nicora@free.fr', '1975-10-24', 1, '2025-12-06 07:42:46.477426', 1, 'Éric Nicora', 'Mise à jour des informations du contact'),
	('14fdf95d-f046-4aeb-a1f6-dad2a70f8638', '319de8c0-be99-4210-9ecc-ba43c0c7e382', '+33607827250', 'eric.nicora@free.fr', '1975-10-24', 2, '2025-12-06 07:42:46.478073', 1, 'Éric Nicora', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d0b22b7d-002b-4013-b9dd-08ac05cd3925', 'ca6789af-a398-4263-919b-026439df484b', '+33687675235', NULL, '1987-11-30', 1, '2025-12-06 07:57:54.416414', 1, 'Cécile Monnier', 'Mise à jour des informations du contact'),
	('1516810e-aee7-4c6c-bfbb-cf8843d40a41', 'ca6789af-a398-4263-919b-026439df484b', '+33687675235', NULL, '1987-11-30', 2, '2025-12-06 07:57:54.416868', 1, 'Cécile Monnier', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('02d0b1b0-2a5a-4c99-9ca8-ed45cada1898', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', NULL, NULL, 1, '2025-12-06 08:02:08.795444', 1, 'Marcky Raharisson', 'Mise à jour des informations du contact'),
	('2b898d4f-04a3-463c-8fef-a3a616323a12', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', NULL, NULL, 2, '2025-12-06 08:02:08.796134', 1, 'Marcky Raharisson', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c5963a67-400e-4820-9118-810d756c23df', 'a543bbd8-04ae-4074-bc43-10de8c0aba69', '+33661868329', 'oliviak68@hotmail.com', '1983-03-13', 1, '2025-12-06 08:25:40.847332', 1, 'Olivia Kwiatkowski', 'Mise à jour des informations du contact'),
	('71ec9a5a-6c04-4e43-8b96-fd5f4e7b5e3a', 'a543bbd8-04ae-4074-bc43-10de8c0aba69', '+33661868329', 'oliviak68@hotmail.com', '1983-03-13', 2, '2025-12-06 08:25:40.848033', 1, 'Olivia Kwiatkowski', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6bd4aaa9-7f57-4d11-9546-b911ad51fa56', 'f570075c-a0f6-4f85-9697-4a313d73bcde', '+33661249828', NULL, NULL, 3, '2025-12-06 08:44:24.89999', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. '),
	('8fd617d0-6453-4c7d-be8c-d9546999eefc', '3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', '+33616798932', 'laurie.moosmann@gmail.com', '1998-09-15', 0, '2025-12-06 08:48:52.712722', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('36d2a4e7-01e0-444a-86f0-315ad5fff955', '3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', '+33616798932', 'laurie.moosmann@gmail.com', '1998-09-15', 1, '2025-12-06 08:48:53.083976', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('0676c126-1e74-405c-80a2-3a71e44a43f3', '10040925-2d1d-461a-9f0b-9eefc08e625c', '+33671827337', 'peggy.santos@hotmail.fr', '1977-09-09', 1, '2025-12-06 09:01:52.377412', 1, 'Peggy Dos Santos', 'Mise à jour des informations du contact'),
	('deef51ca-c6f6-4d61-9cf3-f96e97d5305b', '10040925-2d1d-461a-9f0b-9eefc08e625c', '+33671827337', 'peggy.santos@hotmail.fr', '1977-09-09', 2, '2025-12-06 09:01:52.377874', 1, 'Peggy Dos Santos', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('8097d8a2-3ce2-4e73-a762-83c785f226d3', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'guillaumemthn@gmail.com', NULL, 0, '2025-12-06 09:05:13.210579', 0, 'Anonyme', 'Enregistrement initial'),
	('17936631-7319-4c22-84a3-0b5564a039c2', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'guillaumemthn@gmail.com', NULL, 1, '2025-12-06 09:05:42.308983', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('8e2cca21-40c2-47e7-9137-a5f292fb97bf', '8d141563-9b62-4b6d-a7c6-b7851d63a519', '+33687450613', 'michel.schneeberger@orange.fr', '1966-10-25', 1, '2025-12-06 09:07:53.607199', 1, 'Michel Schneeberger', 'Mise à jour des informations du contact'),
	('090db479-c2b6-4915-b96c-f11812d69152', '8d141563-9b62-4b6d-a7c6-b7851d63a519', '+33687450613', 'michel.schneeberger@orange.fr', '1966-10-25', 2, '2025-12-06 09:07:53.607801', 1, 'Michel Schneeberger', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('0f798f88-2619-486d-a8ea-e2355e2212f3', '3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', '+33616798932', 'laurie.moosmann@gmail.com', '1998-09-15', 2, '2025-12-06 09:10:03.880238', 1, 'Laurie  Moosmann', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ed8c849f-79c2-46ad-9d3b-026afdd03c80', 'cc6be365-6e48-4469-b86e-4b92265778fc', '+33629332926', 'luc.walliser67500@gmail.com', NULL, 0, '2025-12-06 09:15:15.767055', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('f6327103-f435-4b6e-8005-9bb54f19e289', 'cc6be365-6e48-4469-b86e-4b92265778fc', '+33629332926', 'luc.walliser67500@gmail.com', NULL, 1, '2025-12-06 09:15:16.317446', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('bbf38e48-938f-41be-a8b4-dfe6360096dc', 'cc6be365-6e48-4469-b86e-4b92265778fc', '+33629332926', 'luc.walliser67500@gmail.com', '2000-10-07', 1, '2025-12-06 09:28:28.015501', 1, 'Luc Walliser', 'Mise à jour des informations du contact'),
	('93e5cbc8-9168-4f52-aabd-afd9e93625f7', 'cc6be365-6e48-4469-b86e-4b92265778fc', '+33629332926', 'luc.walliser67500@gmail.com', '2000-10-07', 2, '2025-12-06 09:28:28.016003', 1, 'Luc Walliser', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6ff5aebc-ea7b-40c8-8028-6172623b847e', '5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', '+33699047451', 'car2fra@gmail.com', '1973-01-06', 1, '2025-12-06 09:39:30.302564', 1, 'Franco Carlucci', 'Mise à jour des informations du contact'),
	('d45e892b-3ded-40f7-b41b-7dade3a9fa44', '5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', '+33699047451', 'car2fra@gmail.com', '1973-01-06', 2, '2025-12-06 09:39:30.303133', 1, 'Franco Carlucci', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1f629e85-c212-4c6b-9850-b29005e6226b', '1599f73a-81e9-4a1e-8dbf-181773065bd7', '+33687346570', NULL, NULL, 1, '2025-12-06 10:20:47.93536', 1, 'Alex Trajean', 'Mise à jour des informations du contact'),
	('c9e3c052-53f1-421d-8bfa-cf452a9d43fa', '1599f73a-81e9-4a1e-8dbf-181773065bd7', '+33687346570', NULL, NULL, 2, '2025-12-06 10:20:47.93581', 1, 'Alex Trajean', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('50956828-08e6-4e37-89dc-085c208ed273', 'c76145f4-3bbe-420a-9873-1410b3b7aff4', '+33670667723', 'john-twelve@hotmail.fr', '1984-07-25', 1, '2025-12-06 11:26:55.804178', 1, 'Jonathan Willaume', 'Mise à jour des informations du contact'),
	('2a2f281f-30c9-440a-851d-a78a531c3405', 'c76145f4-3bbe-420a-9873-1410b3b7aff4', '+33670667723', 'john-twelve@hotmail.fr', '1984-07-25', 2, '2025-12-06 11:26:55.805006', 1, 'Jonathan Willaume', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('f3dfeea4-768b-4249-8285-93fe0b017383', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', NULL, '1961-01-01', 1, '2025-12-06 12:38:09.85789', 1, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('1b0118c0-ccc2-4fda-b3f9-a77767aeb925', '4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', '+33684190357', 'kris.80@hotmail.fr', '1980-02-11', 1, '2025-12-06 12:42:31.318172', 1, 'Christelle Himber', 'Mise à jour des informations du contact'),
	('5d46c043-6c56-446c-ac0b-246a59aafe63', '4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', '+33684190357', 'kris.80@hotmail.fr', '1980-02-11', 2, '2025-12-06 12:42:31.318756', 1, 'Christelle Himber', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('a1d393f1-31b8-4051-9864-6b82d6174f40', 'a2e94284-c225-4063-8447-11175e49f030', '+33647787728', 'dns.laurent@live.fr', '1987-10-03', 1, '2025-12-06 13:48:47.230161', 1, 'Denis Laurent', 'Mise à jour des informations du contact'),
	('38e453de-7105-4a33-b0b8-648532ec1411', 'a2e94284-c225-4063-8447-11175e49f030', '+33647787728', 'dns.laurent@live.fr', '1987-10-03', 2, '2025-12-06 13:48:47.242869', 1, 'Denis Laurent', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('72fb76ca-8a86-41a1-abfe-0ab19029d875', '58fd23db-ac36-4dfe-aa28-e93a9e7797f8', '+33615072092', 'eric.chautant@yahoo.fr', '1972-12-05', 1, '2025-12-06 15:19:56.217754', 1, 'Éric Chautant', 'Mise à jour des informations du contact'),
	('a4df00d4-d5e8-4d4c-a0f4-acc6a59a69bc', '58fd23db-ac36-4dfe-aa28-e93a9e7797f8', '+33615072092', 'eric.chautant@yahoo.fr', '1972-12-05', 2, '2025-12-06 15:19:56.218806', 1, 'Éric Chautant', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1d552878-557f-4793-8693-792873afbe27', 'fef02115-d090-4a47-92af-bc51cc7b0557', '+33642931441', 'emeline.esselin@gmail.com', '1987-08-04', 1, '2025-12-06 15:26:28.77808', 1, 'Emeline Esselin', 'Mise à jour des informations du contact'),
	('298ac691-a56d-449d-9819-00cfd36f21ad', 'fef02115-d090-4a47-92af-bc51cc7b0557', '+33642931441', 'emeline.esselin@gmail.com', '1987-08-04', 2, '2025-12-06 15:26:28.779045', 1, 'Emeline Esselin', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d9983c6f-053a-4caf-ad45-2270802e09ac', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', NULL, NULL, 0, '2025-12-06 15:28:21.255269', 0, 'Anonyme', 'Enregistrement initial'),
	('88da12a2-7740-4066-9662-6d600609b6ef', '9913046a-680a-42fc-8c33-1c7cc517aeef', '+33659200650', 'celia.schub@gmail.com', '1987-06-10', 1, '2025-12-06 16:18:24.306956', 1, 'Celia Schub', 'Mise à jour des informations du contact'),
	('96820ab9-0ae8-497b-a582-397e3d9b1bd0', '9913046a-680a-42fc-8c33-1c7cc517aeef', '+33659200650', 'celia.schub@gmail.com', '1987-06-10', 2, '2025-12-06 16:18:24.307983', 1, 'Celia Schub', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('295bee11-6b64-4cd5-b770-4dbf7f120edf', '3af6f2b8-1760-4d5c-b08c-7e100d33335d', '+33771271612', 'camaradamba@gmail.com', '1993-12-16', 1, '2025-12-06 17:24:33.579639', 1, 'Damba Camara', 'Mise à jour des informations du contact'),
	('a68996ef-181e-4ee9-8e36-6a5a978934be', '3af6f2b8-1760-4d5c-b08c-7e100d33335d', '+33771271612', 'camaradamba@gmail.com', '1993-12-16', 2, '2025-12-06 17:24:33.593158', 1, 'Damba Camara', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('722f0215-c764-407b-b0e6-a44ab9dd0942', 'aa585d61-6ec4-4be2-b637-b0cb16a830cb', '+33679159125', 'smt.clement@gmail.com', '1991-09-07', 1, '2025-12-06 17:58:56.67804', 1, 'Clement Schmitt', 'Mise à jour des informations du contact'),
	('4e3c717b-4955-431b-98e1-05214233db51', 'aa585d61-6ec4-4be2-b637-b0cb16a830cb', '+33679159125', 'smt.clement@gmail.com', '1991-09-07', 2, '2025-12-06 17:58:56.679083', 1, 'Clement Schmitt', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('dcfa32e3-fbf0-4ce3-b3dd-1ea44c7c82f8', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33627261147', NULL, NULL, 1, '2025-12-06 19:37:21.843366', 1, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('2cb08acf-96de-436c-b1d6-d30231a77e45', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33627261147', NULL, '1984-07-04', 1, '2025-12-06 19:40:16.057106', 1, 'Guillaume Reich', 'Mise à jour des informations du contact'),
	('9f76f95c-0605-49f7-a757-df584ae0bf94', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33627261147', NULL, '1984-07-04', 2, '2025-12-06 19:40:16.058253', 1, 'Guillaume Reich', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ee1988b2-4a15-49c2-bd2d-8feb1aa65e65', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', NULL, NULL, 1, '2025-12-07 02:11:26.122285', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('8253fe62-39d7-4c5c-9a88-1a350e138d58', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 1, '2025-12-07 02:11:53.717731', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.'),
	('aec05795-b43e-47b1-a366-ee6bc6104c0b', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', NULL, NULL, 5, '2025-12-07 04:55:55.949432', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('33ca9def-b3d4-4000-bcba-048ffe36c265', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 5, '2025-12-07 04:56:10.775463', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ea0aba07-d77f-4db5-90cb-281d989b76ae', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 0, '2025-12-07 04:58:19.780887', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('1182cc86-dcc5-42ba-9f1b-87bdd4c1b408', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 5, '2025-12-07 04:58:20.095195', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('738c728d-3ab1-4843-94fd-c328fc877312', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 6, '2025-12-07 04:58:28.080529', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> LIEN ENVOYÉ [ARRIVÉ]'),
	('77488ce2-120e-445c-8f38-7767613ae883', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 2, '2025-12-07 04:58:50.692535', 1, 'SEBASTIEN BURCKHARDT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('9bcd2386-e6b2-46f2-aaf5-b92c1d4533b4', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', NULL, NULL, 1, '2025-12-07 08:35:59.569528', 1, 'Celine Noel', 'Mise à jour des informations du contact'),
	('5e9878cc-bf01-45c4-be5d-b11b5c788b26', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', NULL, NULL, 2, '2025-12-07 08:35:59.57054', 1, 'Celine Noel', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('fa40b383-2b60-4186-8fce-cc9966f83f75', '4398bcec-fb29-41c3-8088-f8ca66120f21', '+33615354743', NULL, NULL, 1, '2025-12-07 09:41:54.734823', 1, 'Joanna Woelfli', 'Mise à jour des informations du contact'),
	('cdbf63e9-0450-4250-b3e6-aa1845786242', '4398bcec-fb29-41c3-8088-f8ca66120f21', '+33615354743', NULL, NULL, 2, '2025-12-07 09:41:54.736078', 1, 'Joanna Woelfli', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c4b338d6-9458-41a6-9de3-5337f17e449b', 'e1b1b0ca-dc2d-458e-a592-23b893f74d09', '+33623182464', 'amelietrusch@gmail.com', '1981-03-19', 0, '2025-12-07 15:43:46.395737', 0, 'Anonyme', 'Enregistrement initial'),
	('1b66e903-11cc-4ea2-98f5-331fdde2fc3e', '22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', '+33608035361', NULL, NULL, 1, '2025-12-07 21:27:59.596973', 1, 'Jérôme Baehr', 'Mise à jour des informations du contact'),
	('7cc67e3c-a66c-4e71-8f5a-7fb5bcd0da13', '22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', '+33608035361', NULL, NULL, 2, '2025-12-07 21:27:59.59782', 1, 'Jérôme Baehr', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('caa359cb-4796-4ad0-b3e0-9d9a2454d1df', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 6, '2025-12-08 05:57:13.406649', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> LIEN ENVOYÉ [ARRIVÉ]'),
	('889df04f-bcbb-464c-b5e5-42fed980f365', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 0, '2025-12-08 13:32:05.846622', 0, 'Anonyme', 'Enregistrement initial'),
	('4c3aaed6-e2a5-4917-bcaf-0f8e96ae982f', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 5, '2025-12-08 13:32:33.188902', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('405c0143-d290-49c9-b7a4-5a5c97c8d183', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 6, '2025-12-08 13:32:42.287616', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> LIEN ENVOYÉ [ARRIVÉ]'),
	('ead90473-e48e-4125-b03b-9266ad2ddd4c', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', '1969-01-01', 6, '2025-12-08 13:33:34.819513', 1, 'SEBASTIEN BURCKHARDT', 'Mise à jour des informations du contact'),
	('83035833-750c-4a8f-a960-48677ac16766', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', '1969-01-01', 2, '2025-12-08 13:33:34.82026', 1, 'SEBASTIEN BURCKHARDT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('7afe28f0-8813-4ae8-b3ec-0631667dc156', '7a9928b8-a216-413c-8619-908f0e0d865d', NULL, NULL, NULL, 4, '2025-12-08 13:34:27.12017', 1, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('c9ff3624-961e-405b-a593-00403fe38953', '7a9928b8-a216-413c-8619-908f0e0d865d', NULL, NULL, NULL, 4, '2025-12-08 13:34:27.121303', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('489d4f7a-588a-4906-a113-6f76a6a8da5d', 'd713af8b-da0d-432f-8ff3-747605cd040f', '+33673186830', 'reichsarah@yahoo.fr', '1985-09-17', 1, '2025-12-08 15:46:59.720085', 1, 'Sarah Reich', 'Mise à jour des informations du contact'),
	('caac6ba4-6045-4d1c-8252-0b0c101ec506', 'd713af8b-da0d-432f-8ff3-747605cd040f', '+33673186830', 'reichsarah@yahoo.fr', '1985-09-17', 2, '2025-12-08 15:46:59.721039', 1, 'Sarah Reich', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('0f732e8b-4034-4db0-9ef1-386ff888dac9', 'bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', '+33681432541', 'Cheesehelb67@gmail.com', '1975-12-06', 1, '2025-12-08 17:10:09.958218', 1, 'Christophe Helbourg', 'Mise à jour des informations du contact'),
	('acea0484-bfb4-4945-85ea-55d8bd03a124', 'bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', '+33681432541', 'Cheesehelb67@gmail.com', '1975-12-06', 2, '2025-12-08 17:10:09.95914', 1, 'Christophe Helbourg', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('a706af1e-d47a-40a6-8eab-96dd7adfa69b', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 0, '2025-12-08 18:04:35.895571', 0, 'Anonyme', 'Enregistrement initial'),
	('b4569236-e408-44b0-a9a0-67458f2b30b7', '06f72afb-571c-470a-9d04-ca83edc9010f', '+33662353483', 'p.lamaack@orange.fr', '1974-06-10', 1, '2025-12-08 20:00:50.510042', 1, 'Philippe Lamaack', 'Mise à jour des informations du contact'),
	('b15ffcba-0a2f-4d5f-ad0c-688c6cc3950f', '06f72afb-571c-470a-9d04-ca83edc9010f', '+33662353483', 'p.lamaack@orange.fr', '1974-06-10', 2, '2025-12-08 20:00:50.511161', 1, 'Philippe Lamaack', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('81bf108f-8574-4d21-8f9d-e89ac3f177e4', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', NULL, NULL, 4, '2025-12-09 03:18:18.011402', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> INJOIGNABLE'),
	('d1dc9ec2-7236-4006-a80c-495d129f3090', 'b63e0a87-088b-4a54-8ce9-619b09ecaf74', '+33685504977', NULL, NULL, 3, '2025-12-09 23:50:44.772224', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. '),
	('ee41a169-5ef6-4514-8759-9f259b1c1ead', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', NULL, '1961-01-01', 1, '2025-12-10 07:08:18.898154', 1, 'Marie Reich', 'Mise à jour des informations du contact'),
	('725af7c9-5ca3-4d32-b182-ab9136de42e0', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', NULL, '1961-01-01', 2, '2025-12-10 07:08:18.898967', 1, 'Marie Reich', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('008b672d-b1af-4ce1-ab09-c8a5878299ea', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 0, '2025-12-13 01:29:21.613214', 0, 'Anonyme', 'Enregistrement initial'),
	('ee8e1c39-19c6-4295-b703-d02abc6705af', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 5, '2025-12-13 01:29:49.281228', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ca9ab7d7-7e07-472b-b07a-3e26ffcd4c47', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 6, '2025-12-13 01:29:59.469315', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> LIEN ENVOYÉ [ARRIVÉ]'),
	('92c34ce6-1b98-456c-8b63-608ab82d084e', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 5, '2025-12-13 01:30:10.651125', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f731ddaa-5b9d-422b-b60a-d5548bf80425', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 6, '2025-12-13 01:30:19.497361', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> LIEN ENVOYÉ [ARRIVÉ]'),
	('596cd4f9-d7ad-49f3-8748-03ab61419208', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 6, '2025-12-13 01:30:36.435425', 1, 'SEBASTIEN BURCKHARDT', 'Mise à jour des informations du contact'),
	('a0816283-5dd3-4c61-af87-0bde9df99a98', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 2, '2025-12-13 01:30:36.43678', 1, 'SEBASTIEN BURCKHARDT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('3b17b248-2261-4366-a1c1-45eb143d8c0a', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', NULL, NULL, 5, '2025-12-13 10:36:44.594616', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8bd5bd8a-be73-4753-b6b1-4484a5a603a7', '16271680-19a8-4184-a754-337364221875', '+33673426632', NULL, NULL, 5, '2025-12-13 10:36:44.95925', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('c94604b2-605d-463f-a471-d9f54a2edebc', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', NULL, NULL, 5, '2025-12-13 10:36:45.286254', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('be16ee21-fd47-4e10-8d37-8d20c3b6a0e8', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', NULL, NULL, 5, '2025-12-13 10:36:45.614533', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d4556d69-8224-46d9-ab33-c46ce71feb8a', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', NULL, NULL, 5, '2025-12-13 10:36:45.922902', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1646b68a-934e-41e3-a988-b8c4105fbba7', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', NULL, NULL, 5, '2025-12-13 10:36:46.244568', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('9a22c1b5-c5f7-4914-8797-bd4dacaaa5a8', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', NULL, NULL, 5, '2025-12-13 10:36:46.60425', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('593a547a-27ce-49e3-b9c5-245710d1c6db', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, NULL, 5, '2025-12-13 10:36:47.106849', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('9ab480b2-8b43-409e-823b-50f5e4e16373', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 5, '2025-12-13 10:36:47.417679', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('e5ca1fdc-d904-427e-8dc7-a16b67372fef', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', NULL, NULL, 5, '2025-12-13 10:36:47.73225', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('9b71437e-9eae-42dd-ab8e-36361dcc54dc', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', NULL, NULL, 5, '2025-12-13 10:36:48.05713', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d73da504-942b-49be-b665-d240855754c9', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', NULL, NULL, 5, '2025-12-13 10:36:48.384709', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('e67e9e70-86b1-4248-b043-124ee1f299cf', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', NULL, NULL, 5, '2025-12-13 10:36:48.694495', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d3d6eb3b-7ac8-4965-81eb-f710fca3dccb', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 5, '2025-12-13 10:36:48.999011', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('e61af7c5-acd7-4cb4-9cfc-1b342005a57e', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 5, '2025-12-13 10:36:49.30723', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('405f7b2c-3b38-4075-98d0-f5ba67a11da9', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', NULL, NULL, 5, '2025-12-13 10:36:49.800571', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('45bb01eb-c08b-4656-820a-6b9386818e48', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', NULL, NULL, 5, '2025-12-13 10:36:50.112203', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f6451ea1-411a-4b9a-a45e-f3e8987dc493', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', NULL, NULL, 5, '2025-12-13 10:36:50.42352', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ecd031b1-a8bf-4c98-b8eb-8ca577cafdae', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 5, '2025-12-13 10:36:50.733247', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('36a39911-893f-485b-aebe-a932812a3623', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', NULL, NULL, 5, '2025-12-13 10:36:51.044185', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2b7829dd-48ba-4b68-bd56-67834ec271b6', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', NULL, NULL, 5, '2025-12-13 10:36:51.349727', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('19638f91-2d99-4a3c-a257-d062e1e7f00f', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 5, '2025-12-13 10:36:51.663997', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('67e1aec8-87ee-4794-97bb-6210847eb0ba', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', NULL, NULL, 5, '2025-12-13 10:36:51.954699', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f7abab41-e6ee-41f1-9868-f517061f8d73', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 5, '2025-12-13 10:36:52.283843', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ce135afa-f0fc-4286-a6a2-1293850a0299', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 5, '2025-12-13 10:36:52.764015', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0198c6f5-cbcf-4c6e-a2bf-791fe1158507', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 5, '2025-12-13 10:36:53.051503', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('abf9b2dc-6780-4f83-a9b2-bba8a5dc1cf8', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 5, '2025-12-13 10:36:53.355765', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1fc324cc-32e5-411f-bc1e-ddf083ee9ce6', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 5, '2025-12-13 10:36:53.642573', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('26938bfc-edbb-412b-90a1-1809e08ed8a3', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 5, '2025-12-13 10:36:53.944797', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('547722b1-64a5-4fdd-bcc2-c4d6ed2b3ba1', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', NULL, NULL, 5, '2025-12-13 10:36:54.245462', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('6e5b7245-d454-4a18-81b1-17b6d2e1b097', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', NULL, NULL, 5, '2025-12-13 10:36:54.720937', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('01fd7339-819e-451a-b178-293578baf623', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', NULL, NULL, 5, '2025-12-13 10:36:55.036822', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f04a6d0e-d289-4774-a849-e2a232fc854a', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 5, '2025-12-13 10:36:55.345624', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('34cb2605-1d74-463a-9272-6485f8805ebd', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', NULL, NULL, 5, '2025-12-13 10:36:55.663958', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('b4977439-a559-497e-b11a-7f2fdba16496', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 5, '2025-12-13 10:36:56.151378', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ae550702-f4a9-48a1-9f71-afdb552e4cd2', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 5, '2025-12-13 10:36:56.455792', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('c9eb2be5-2f9e-4390-85b8-66993f05179b', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', NULL, NULL, 5, '2025-12-13 10:36:56.762628', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('6f6ea608-506b-410e-b1b3-cb0a5f74aad4', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', NULL, NULL, 5, '2025-12-13 10:36:57.057134', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f8470a10-cd99-43dd-9fe5-9312a21954eb', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 5, '2025-12-13 10:36:57.365096', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('dfa989f5-3fa6-4058-a2fd-4d0c49dbfd7c', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', NULL, NULL, 5, '2025-12-13 10:36:57.651191', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('633decb7-04b1-422a-80e6-bf0d6fb150b9', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 5, '2025-12-13 10:36:57.956745', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('fcf1b2ca-739e-4c1a-8d4c-4a1a1c78e5b2', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', NULL, NULL, 5, '2025-12-13 10:36:58.44221', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('60e8025a-c73e-4aba-aff7-1e352107bda2', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 5, '2025-12-13 10:36:58.728058', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('88fa49e2-6094-4b21-be69-3f1b38cd6696', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 5, '2025-12-13 10:36:58.997063', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0c6a8616-8521-4348-98b6-f6079db04962', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 5, '2025-12-13 10:36:59.470586', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('a2f07d62-c6c6-48df-9eae-45b78c188845', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 5, '2025-12-13 10:36:59.77366', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f6634a30-748d-4640-af2a-a8edf8917ef1', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', NULL, NULL, 5, '2025-12-13 10:37:00.070617', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('933e9e0e-5ead-4763-856c-47dac384cd69', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 5, '2025-12-13 10:37:00.372854', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('a44aea02-096f-4457-8c1a-0d0ed520d7f0', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 5, '2025-12-13 10:37:00.844485', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('021d6d1b-5b1d-4ace-aa4a-a83be56a8fd9', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 5, '2025-12-13 10:37:01.15849', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('4c8d7284-c569-4b91-a337-26eecb83eac9', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 5, '2025-12-13 10:37:01.469512', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8abd41da-88c4-4aa2-86ed-260f70e5ea53', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', NULL, NULL, 5, '2025-12-13 10:37:01.765037', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('a3696f1a-a5b9-439c-9ee6-3319daefd0e2', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 5, '2025-12-13 10:37:02.049605', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d5a73701-eb63-4052-a88b-40ea6d677238', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', NULL, NULL, 5, '2025-12-13 10:37:02.355558', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8f23f601-7dad-422b-9eb0-79f1e5f3404f', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 5, '2025-12-13 10:37:02.646047', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('391e0bf8-4028-449f-a75d-a11b347c53c6', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 5, '2025-12-13 10:37:02.941297', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('008c12b4-e9d0-4082-852d-bd94af129995', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 5, '2025-12-13 10:37:03.226808', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1efda565-57a0-4576-9dfd-f615fc4705ba', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, NULL, 5, '2025-12-13 10:37:03.506118', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('08d94c4d-d3c9-476e-b522-2da43b4aec6b', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 5, '2025-12-13 10:37:03.806013', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('44e50d60-e4ab-454f-a4c5-50c15b224e04', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 5, '2025-12-13 10:37:04.104419', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('425a7887-b827-420f-9a8c-8a5f4743c15b', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 5, '2025-12-13 10:37:04.405788', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0330d38f-4d58-40f6-af57-351765328bfd', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 5, '2025-12-13 10:37:04.871128', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('174b8c38-3df7-42a2-bd74-f42ab05fdb79', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', NULL, NULL, 5, '2025-12-13 10:37:05.155163', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('97a42460-35d8-42c5-9e75-7024b63d8080', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 5, '2025-12-13 10:37:05.430432', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('689063db-77a0-46a4-8cb0-80b1d5a22e4b', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 5, '2025-12-13 10:37:05.728884', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f5cae320-d037-4c23-a441-4db519e0faf1', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, NULL, 5, '2025-12-13 10:37:06.20273', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f71efe36-2fa9-45d4-9fe4-ff5f2966a948', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 5, '2025-12-13 10:37:06.491197', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('36f1431c-d61f-45f4-b381-34fd4bf992aa', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', NULL, NULL, 5, '2025-12-13 10:37:06.771327', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ffa86f9d-788c-47d9-b86e-306f39a5c192', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 5, '2025-12-13 10:37:07.077549', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8f2cd59a-bc2b-4305-b493-51508e368bda', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 5, '2025-12-13 10:37:07.536162', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ae59952b-24e6-4875-918f-e6fff035d1fa', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', NULL, NULL, 5, '2025-12-13 10:37:07.838792', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2901eb17-cb1f-4157-9a93-ba3f9d5aff3d', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, NULL, 5, '2025-12-13 10:37:08.306947', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('4deef38b-3fc6-4fd1-be18-885db654918a', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 5, '2025-12-13 10:37:08.595001', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('b704c55b-bb4a-4cf8-9a18-07fd1c308481', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 5, '2025-12-13 10:37:08.915413', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('581e5d2b-7751-4c0a-a24c-fab4be1f90b5', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', NULL, NULL, 5, '2025-12-13 10:37:09.206605', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('7e3d7b53-85b1-4e92-9fc0-63bee0df6e5e', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 5, '2025-12-13 10:37:09.492399', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0321eb00-3c16-427d-8d30-0b85ab749189', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', NULL, NULL, 5, '2025-12-13 10:37:09.790516', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('141cafcc-fa5e-402b-9164-7293b25b1788', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'guillaumemthn@gmail.com', NULL, 5, '2025-12-13 10:37:10.091363', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('493e295a-7619-43ea-bf7c-998e49fde50e', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', NULL, NULL, 5, '2025-12-13 10:37:10.428565', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('c2dd30a6-511b-42de-9e0a-509b88848405', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', NULL, NULL, 5, '2025-12-13 10:37:10.734348', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('84c6a6db-743b-4658-b8c1-f996a38e8fab', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 5, '2025-12-13 10:37:11.044412', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('06eab557-fd4b-485d-85e5-ac398471e5c9', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 5, '2025-12-13 10:37:11.341505', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('66331687-3517-43c8-bb9c-1501db6123e4', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 5, '2025-12-13 10:37:11.634519', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('aa119de0-c62d-499b-8a41-f7e3f5c31088', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 5, '2025-12-13 10:37:11.924548', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('47a539f5-941f-45af-b840-2afee0754f60', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 5, '2025-12-13 10:37:12.216819', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('bbd91a80-0157-444a-8835-cb818b520d9e', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', NULL, NULL, 5, '2025-12-13 10:37:12.521769', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('4c82be25-4a01-4305-bb78-d7249d4f82da', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', NULL, NULL, 5, '2025-12-13 10:37:12.817347', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('35b8f34a-e643-4ae9-9a44-207a5c916834', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 5, '2025-12-13 10:37:13.099203', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1e2e6713-014d-4da0-8738-e4a73c0e3f24', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 6, '2025-12-13 10:37:14.445803', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e3bf8300-5295-42e0-be5b-2caba0ff6aa2', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', NULL, NULL, 6, '2025-12-13 10:37:14.644671', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('5e1b3378-f562-4b64-8ada-bca3082d6a7c', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 6, '2025-12-13 10:37:14.948652', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('4081d4c0-5735-4050-9482-687d1cc75b85', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 6, '2025-12-13 10:37:15.320044', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('52e822bc-d84f-409a-804c-fb341b5b49d0', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, NULL, 6, '2025-12-13 10:37:15.522394', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('134cf78e-403f-45ec-8e42-191d68a83a1b', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 6, '2025-12-13 10:37:15.666963', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('d526ce66-2898-4706-aaa7-1339f66fdcbe', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 6, '2025-12-13 10:37:15.962121', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('12d8cd7d-62d7-44c2-bb55-d3d8a0f217e0', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 6, '2025-12-13 10:37:16.226104', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('1ef522be-589a-4951-bee9-dc73e106f216', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 6, '2025-12-13 10:37:16.391207', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('4adbdeb1-e796-4d76-b75f-fb65ba443537', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 6, '2025-12-13 10:37:17.031066', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('840fb818-39ae-4814-a910-67455fbbb739', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 6, '2025-12-13 10:37:18.285896', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('caf90bd8-adf4-4999-8972-2f5ff5ee8c18', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 6, '2025-12-13 10:37:18.865124', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ca5fa5f3-1a77-4a75-9b74-3b8955ff7a42', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', NULL, NULL, 6, '2025-12-13 10:37:19.694771', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c4609279-1482-4874-ada1-d101986c41b6', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, NULL, 6, '2025-12-13 10:37:19.879182', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('57f47a05-bd68-4e11-be8c-be5441011c67', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 6, '2025-12-13 10:37:20.013943', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c28cf57d-74ed-417f-992f-3ef49ddc3efc', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 6, '2025-12-13 10:37:20.276832', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ffc79fb4-9d4e-4659-814d-3f2aac3facee', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 6, '2025-12-13 10:37:21.108837', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('4befe0e5-242a-453e-9e64-ed9c5abbc4d5', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', NULL, NULL, 6, '2025-12-13 10:37:21.125086', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('89de624b-e3ea-4d91-ba43-ce9fff23b0b0', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 6, '2025-12-13 10:37:21.460817', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('3942b909-2946-41d7-94d7-a0f847c52903', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', NULL, NULL, 6, '2025-12-13 10:37:21.673745', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('aeff01f0-51c4-46af-9736-96bad3e7cf2a', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', NULL, NULL, 6, '2025-12-13 10:37:21.8546', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('40f134f8-02b4-43a7-8c80-bf9faa20a3d2', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 6, '2025-12-13 10:37:21.97322', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0f87a5fa-5440-43b1-a669-d93b9a2938a9', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 6, '2025-12-13 10:37:22.543805', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9dd0e505-33ec-4f88-a584-067eee47887c', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', NULL, NULL, 6, '2025-12-13 10:37:24.494325', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e299586f-7365-4190-b4ba-86446220b45c', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 6, '2025-12-13 10:37:25.063726', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('5218357a-3f1b-4510-a6b3-4a0b21e7cff3', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 6, '2025-12-13 10:37:25.458984', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('3c93b80a-9a24-4606-a74a-11abc0d78c65', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 6, '2025-12-13 10:37:25.982752', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('1d8e271c-1d9e-4fa0-bd8d-eb9a2c63a43f', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 6, '2025-12-13 10:37:26.396253', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ccd5e91e-ad1b-4eed-8b13-354b0e45c52a', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 6, '2025-12-13 10:37:28.386459', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('bc15cdd0-3d00-45e5-9021-38457431674d', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 6, '2025-12-13 10:37:29.234773', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('31e85919-08c3-42d5-96ae-1950e10d93bd', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 6, '2025-12-13 10:37:32.42735', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('4552de2f-929d-4e06-b196-7e5c60962cfc', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 6, '2025-12-13 10:37:17.178709', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('631f7f1d-967a-403d-bd99-1bd05e48814a', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, NULL, 6, '2025-12-13 10:37:20.600199', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('052597ea-2210-45d2-bc2e-103413b0b67e', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 6, '2025-12-13 10:37:22.258509', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('6627ecda-33a4-451a-a2dc-ee6f094fb9a8', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 6, '2025-12-13 10:37:23.164779', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f620de66-5ccf-406d-8292-d28f496c7b4a', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'guillaumemthn@gmail.com', NULL, 6, '2025-12-13 10:37:26.307849', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('1dba131a-7bcb-40c5-8855-cc8b8186c254', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 6, '2025-12-13 10:37:27.651253', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('16ae0c54-b6ad-4f06-b944-a148a7cc63c3', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 6, '2025-12-13 10:37:17.892803', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e9daa1f0-6657-4c67-be5f-592121dcf253', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', NULL, NULL, 6, '2025-12-13 10:37:20.845855', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ab74738e-49f5-4324-8273-a48469be214a', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', NULL, NULL, 6, '2025-12-13 10:37:24.092553', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('69316337-1b01-4248-80c0-81f04cdca801', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', NULL, NULL, 6, '2025-12-13 10:37:27.719884', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0443422e-9c4e-4abb-a0f7-51c74baf1663', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'guillaumemthn@gmail.com', NULL, 2, '2025-12-13 10:39:35.640077', 1, 'Guillaume Mathon', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ada9ca99-e260-4a5e-a5d8-632b45899a79', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, '1976-01-30', 6, '2025-12-13 10:41:06.919956', 1, 'Murielle Kircher', 'Mise à jour des informations du contact'),
	('f90e4491-5a33-41f1-a9e9-4d0c3b9c8eda', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', NULL, '1976-01-30', 2, '2025-12-13 10:41:06.920726', 1, 'Murielle Kircher', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('21545344-54a0-45c8-8881-b81e8e4dcac5', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', 'cedricott@msn.com', '1987-09-06', 5, '2025-12-13 10:42:49.079144', 1, 'Cedric Ott', 'Mise à jour des informations du contact'),
	('cb6568a3-6e4f-45aa-9284-5919ecb2587f', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', 'cedricott@msn.com', '1987-09-06', 2, '2025-12-13 10:42:49.079908', 1, 'Cedric Ott', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6bf98db7-bc49-4600-87ac-8f5c0cc35d46', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', NULL, '1971-04-09', 5, '2025-12-13 10:47:37.618755', 1, 'Michel AMIEL', 'Mise à jour des informations du contact'),
	('0498cd85-928d-4967-88de-9db72a291107', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', NULL, '1971-04-09', 2, '2025-12-13 10:47:37.619504', 1, 'Michel AMIEL', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('07686c23-537a-48ab-9480-dd336f76db10', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', NULL, NULL, 5, '2025-12-13 10:48:06.348831', 1, 'Florian Baehr', 'Mise à jour des informations du contact'),
	('f9eecbd5-bdc8-40da-86fc-511cf3eb0c0c', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', NULL, NULL, 2, '2025-12-13 10:48:06.349475', 1, 'Florian Baehr', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('8825ab56-52b0-4838-b08d-c5358ccc3ca2', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', 'emmanuellemichel67@gmail.com', '1980-08-27', 5, '2025-12-13 10:53:37.189279', 1, 'Emmanuelle Michel', 'Mise à jour des informations du contact'),
	('1b880122-54fa-4566-a661-734b8e346f81', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', 'emmanuellemichel67@gmail.com', '1980-08-27', 2, '2025-12-13 10:53:37.189843', 1, 'Emmanuelle Michel', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('97a14aac-f423-4f50-80fe-04f29a8ea644', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', 'maeva.voisin@gmail.com', '1992-03-20', 5, '2025-12-13 10:59:55.771412', 1, 'Maeva  Voisin', 'Mise à jour des informations du contact'),
	('5b6abb35-7599-44f0-88f2-80f36708c42b', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', 'maeva.voisin@gmail.com', '1992-03-20', 2, '2025-12-13 10:59:55.772159', 1, 'Maeva  Voisin', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('53fb3669-c1ea-47b3-b336-184869844b6c', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', 'jeromebacchiani@gmail.com', '1971-02-07', 6, '2025-12-13 11:18:24.357504', 1, 'Jeje - Jérome  Bacchiani', 'Mise à jour des informations du contact'),
	('45e23589-237d-4fb2-a56a-e7a0d530e007', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', 'jeromebacchiani@gmail.com', '1971-02-07', 2, '2025-12-13 11:18:24.358527', 1, 'Jeje - Jérome  Bacchiani', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('91f0fc1c-5bdf-4c87-8b0c-fed2ca94b1a4', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, '1987-02-01', 6, '2025-12-13 11:53:53.333906', 1, 'matthieu belhaddad', 'Mise à jour des informations du contact'),
	('5840c91b-bb3d-4f80-b445-5354bc1b7e3a', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', NULL, '1987-02-01', 2, '2025-12-13 11:53:53.335095', 1, 'matthieu belhaddad', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6811ad37-7518-4b0d-910f-a1166fcae783', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', 'Nicoc68@hotmail.com', '1983-04-28', 5, '2025-12-13 12:14:22.486318', 1, 'Nicolas CARON', 'Mise à jour des informations du contact'),
	('58103b80-dbee-46b8-aeec-7aefc5e4a11a', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', 'Nicoc68@hotmail.com', '1983-04-28', 2, '2025-12-13 12:14:22.486983', 1, 'Nicolas CARON', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('8ac0b793-b4f7-4161-9338-88b727228b81', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, '1990-01-07', 6, '2025-12-13 12:22:25.764827', 1, 'Lucas Felten', 'Mise à jour des informations du contact'),
	('d8087e6a-71e1-4433-a8a7-3972ad5ccf72', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', NULL, '1990-01-07', 2, '2025-12-13 12:22:25.765521', 1, 'Lucas Felten', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c15a9ab3-dac1-462e-bfa9-7b6e491a83af', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', NULL, NULL, 0, '2025-12-13 15:24:52.060328', 0, 'Anonyme', 'Enregistrement initial'),
	('415eee17-f992-4037-9f31-d434e676b9ce', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', 'moraida.joffrey@hotmail.fr', '1988-02-12', 5, '2025-12-13 16:15:31.075725', 1, 'Joffrey Moraida', 'Mise à jour des informations du contact'),
	('4d1bf83e-5d10-4119-afbb-f1fec242e4d8', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', 'moraida.joffrey@hotmail.fr', '1988-02-12', 2, '2025-12-13 16:15:31.078236', 1, 'Joffrey Moraida', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('b9a92094-3bb1-44c5-8680-32a6b5d1122e', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', NULL, NULL, 5, '2025-12-13 21:38:41.303222', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('77be819f-1092-4a8c-b6ce-00e21135972b', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', NULL, NULL, 6, '2025-12-14 00:43:43.750349', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('08c3f093-5d73-4423-ba37-f95a2cd0ea86', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', 'laurelinelhotellier@hotmail.fr', '1987-10-09', 6, '2025-12-14 00:45:10.614683', 1, 'Lauréline  L’hotellier', 'Mise à jour des informations du contact'),
	('efaf2ebc-7be7-43fa-bf9e-a9e7997b8c34', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', 'laurelinelhotellier@hotmail.fr', '1987-10-09', 2, '2025-12-14 00:45:10.61561', 1, 'Lauréline  L’hotellier', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('a5a01fad-547d-4c7e-bb69-21d6d06049c9', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 3, '2025-12-14 05:13:53.189103', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. '),
	('4ca744b8-e7e3-487c-8fe1-920f610600d5', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 6, '2025-12-14 08:17:21.440523', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c72c1d71-e479-4547-855a-36794495058e', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', NULL, NULL, 6, '2025-12-14 08:19:31.809771', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('10e0207a-9667-4493-b303-e50c9a523ec3', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', NULL, NULL, 6, '2025-12-14 08:19:40.486468', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f357f170-a902-43b3-9db9-3958b80949fb', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 6, '2025-12-14 08:19:44.858505', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('34b3299b-47f6-4622-92ea-aedd6c2819e6', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 6, '2025-12-14 08:19:47.029692', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('d6696014-8531-4c8a-84d7-a6088488a65e', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 6, '2025-12-14 08:20:17.381967', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('03975d10-6a82-43fb-91a8-255bbe06cbf7', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 6, '2025-12-14 08:20:19.547784', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('cdb2f73a-e059-4777-bce4-81413caa59fc', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 6, '2025-12-14 08:20:38.759258', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('363f7ee1-a3a1-4c1a-ad26-4b96eae2431c', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 6, '2025-12-14 08:20:54.065285', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('25c739ea-1c29-4dab-9ddb-52003e0cbba5', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', NULL, NULL, 6, '2025-12-14 08:21:28.036495', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('15da4f2e-9e51-414b-b4cc-47e471d070dc', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 6, '2025-12-14 08:21:46.456157', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('39694fa7-5e6f-4e3a-ad02-04a9837afe25', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 6, '2025-12-14 08:21:59.54599', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('01cead8f-cab4-4f0c-a3c6-0f6ed8c8fa25', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 6, '2025-12-14 08:22:32.273551', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('b43b8492-ee0e-4e27-9ec8-db3bd72d995f', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 6, '2025-12-14 08:22:34.513456', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('13eedb5f-468d-403a-bb2e-393ea1f0e57a', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 6, '2025-12-14 08:22:41.356866', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('7b887b39-68de-4323-a842-5ba2fd5553df', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', NULL, NULL, 6, '2025-12-14 08:22:47.824033', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ead1972c-42e7-433a-aec6-788099cfe1f3', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 6, '2025-12-14 08:22:53.092037', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('29ea128c-1c8a-4956-af10-7592d81972ad', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 6, '2025-12-14 08:24:24.540656', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('decf147d-c271-4838-9058-c89507dfc365', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 6, '2025-12-14 08:41:51.525707', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('358f2556-13e3-46e3-ab77-a06ceb6d7ecf', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 6, '2025-12-14 08:41:55.494748', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9ef5fab2-86b4-423c-98d5-efe686f24aa9', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', 'celine.bognitscheff@gmail.com', '1987-04-21', 2, '2025-12-14 11:54:18.552241', 1, 'Céline Bognitscheff', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('707778e6-1c41-4a42-a84d-faed3063ee21', 'e1b1b0ca-dc2d-458e-a592-23b893f74d09', '+33623182464', 'amelietrusch@gmail.com', '1981-03-19', 5, '2025-12-14 12:51:44.958125', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('7fc92567-f58e-4d91-b35c-4d04b936faed', 'e1b1b0ca-dc2d-458e-a592-23b893f74d09', '+33623182464', 'amelietrusch@gmail.com', '1981-03-19', 6, '2025-12-14 12:51:53.945408', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e4a83bb5-23a1-4777-a394-3c5db07a884b', 'e1b1b0ca-dc2d-458e-a592-23b893f74d09', '+33623182464', 'amelietrusch@gmail.com', '1981-03-19', 2, '2025-12-14 12:53:36.908114', 1, 'Amélie TRUSCH', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c17af034-da31-4289-87da-0f68166892c8', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 6, '2025-12-14 21:01:31.595447', 1, 'Yannick Lienhart', 'Mise à jour des informations du contact'),
	('ff67e42e-bf2f-4b2b-960f-32ccefdc35f4', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', NULL, NULL, 2, '2025-12-14 21:01:31.596367', 1, 'Yannick Lienhart', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('19806961-23c0-4bcf-b6f2-8c4aea4294a8', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', NULL, NULL, 5, '2025-12-15 05:05:04.802711', 1, 'Stephanie Wolozyn', 'Mise à jour des informations du contact'),
	('6f9b38bf-361e-47e9-996a-f3d8c2de1472', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', NULL, NULL, 2, '2025-12-15 05:05:04.803647', 1, 'Stephanie Wolozyn', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('9c16c0f7-f2f4-410e-bc8b-346a0c02ab85', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', 'chelmi@evc.net', '1968-04-24', 6, '2025-12-15 16:09:05.797969', 1, 'Michel Mutschler', 'Mise à jour des informations du contact'),
	('974a5d25-ba3a-4c4e-820d-4597dc1b4e29', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', 'chelmi@evc.net', '1968-04-24', 2, '2025-12-15 16:09:05.799784', 1, 'Michel Mutschler', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('04461aaf-f4ed-4849-8409-8928fd058a06', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', NULL, NULL, 4, '2025-12-16 10:37:23.37159', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> INJOIGNABLE'),
	('979e2b9b-0c63-4a65-b8ea-f16dda20ef22', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', 'tcolnot2@gmail.com', '1970-08-09', 2, '2025-12-18 10:21:25.672044', 1, 'Thierry Colnot', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('e5b8c62a-4fd2-42fb-9268-e1265668b989', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', 'moha.sahli@hotmail.fr', '1977-03-04', 6, '2025-12-18 10:54:49.263564', 1, 'Momo Sahli', 'Mise à jour des informations du contact'),
	('768b76dc-2100-403b-bd09-d46452ce20ba', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', 'moha.sahli@hotmail.fr', '1977-03-04', 2, '2025-12-18 10:54:49.264595', 1, 'Momo Sahli', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('db03cbc2-8472-41e6-bc2e-f8bcfb254924', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', NULL, NULL, 2, '2025-12-18 11:56:38.244927', 1, 'Melanie Chaouch', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ff5708af-20b9-4b36-8b0b-ae9cb7cdf0a9', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', 'michael.hauler@gmail.com', NULL, 2, '2025-12-18 20:26:05.690813', 1, 'Michael Hauler', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('f8b60f35-2a38-4b38-9e33-6270b9ff013f', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', 'moha.sahli@hotmail.fr', '1977-03-04', 2, '2025-12-19 07:19:27.76113', 1, 'Momo Sahli', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('7c3d5a39-6378-4a89-ab95-21598ec29d5f', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', NULL, NULL, 2, '2025-12-19 22:23:17.850236', 1, 'Celine Noel', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('fcc28bf9-89c9-4980-9558-952a899d868b', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', 'cedricott@msn.com', '1987-09-06', 2, '2025-12-20 08:29:23.223993', 1, 'Cedric Ott', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('78cb1610-0d80-4868-9f5d-182eb1a84b77', '72ffb7dd-50b3-4cc9-8a28-df9dd18795f2', NULL, NULL, NULL, 4, '2025-12-20 15:44:34.849413', 0, 'Anonyme', 'Enregistrement initial'),
	('5ee69395-cbd5-447f-90ce-468a0dc91599', '72ffb7dd-50b3-4cc9-8a28-df9dd18795f2', NULL, NULL, NULL, 4, '2025-12-20 15:44:57.688724', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('bfbae56c-e289-4f1a-97e1-7123f50c55db', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'sebastien.burckhardt@gmail.com', NULL, 2, '2025-12-20 15:47:28.703234', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('04977c61-234f-42dc-a573-665325cfd3a1', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'sebastien.burckhardt@hoenheimsports.fr', NULL, 2, '2025-12-20 15:47:37.159481', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('63bb45be-ff74-465e-ade5-6973074d0658', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'sebastien.burckhardt@gmail.com', '1969-01-01', 2, '2025-12-20 15:47:45.288896', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('03ef6337-e4c2-4d7a-86c0-36f6a4474266', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', NULL, NULL, 0, '2025-12-20 16:01:47.676849', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5bbe0868-25df-4709-b25d-bdc5a1971715', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', NULL, NULL, 5, '2025-12-20 16:01:48.418564', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ea244e22-99b8-4d5e-8a09-7b862214126e', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 0, '2025-12-20 16:01:48.434073', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('77bc1866-b9b2-4328-b4cb-284facbf67fb', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 5, '2025-12-20 16:01:48.745832', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0aa96f4b-f6c3-4d38-80d8-69c98671237c', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', NULL, NULL, 0, '2025-12-20 16:01:48.762478', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('52770972-bfad-4492-b4f0-7505e7314e99', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', NULL, NULL, 5, '2025-12-20 16:01:49.072994', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f982fe81-ee22-45c9-a8b9-27b638b5dccd', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', NULL, NULL, 0, '2025-12-20 16:01:49.093738', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ae8dd557-604e-4eca-bc4a-4c59a0be9a23', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', NULL, NULL, 5, '2025-12-20 16:01:49.415605', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('c02b1f3a-0ff5-4656-9581-01f659521412', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', NULL, NULL, 0, '2025-12-20 16:01:49.437628', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b872c481-354d-40d4-9984-e13c12aa657c', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', NULL, NULL, 5, '2025-12-20 16:01:49.790321', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('a23cca3d-aea0-49d0-b3b6-9c26bf4af842', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 0, '2025-12-20 16:01:49.805223', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('69c2686e-8e69-472a-8822-f8cc28571f81', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 5, '2025-12-20 16:01:50.113478', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('e7147ef1-63de-4b22-9102-c44d649b885b', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 0, '2025-12-20 16:01:50.130294', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('6341cd52-d9fe-470d-ad88-352d822dc7ea', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 5, '2025-12-20 16:01:50.455604', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('791d6583-4bb2-4d26-b9b9-3d61f530e395', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', NULL, NULL, 0, '2025-12-20 16:01:50.475012', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c1e35d6a-e6e6-4a77-b760-b4cb503d38d8', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', NULL, NULL, 5, '2025-12-20 16:01:50.796028', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d33fe9f8-9ab4-436b-8a1b-2310c5bd8f53', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', NULL, NULL, 0, '2025-12-20 16:01:50.810991', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('d2688b7e-22d9-46ed-8dfe-cd1228dc3619', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', NULL, NULL, 5, '2025-12-20 16:01:51.13529', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1f72ecef-87c6-4cf5-a7ba-ac077a7d9eb2', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', NULL, NULL, 0, '2025-12-20 16:01:51.149951', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('c830ef1e-a711-4c5d-ade6-11f7304cb52b', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', NULL, NULL, 5, '2025-12-20 16:01:51.455065', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8ec8e5a6-bb66-4642-942c-46df8ddb47a2', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', NULL, NULL, 0, '2025-12-20 16:01:51.4685', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('5bfea939-8044-448c-9b14-a37b5e713b3e', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', NULL, NULL, 5, '2025-12-20 16:01:51.785606', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2615e73d-1976-4aea-b5f7-510e93bad626', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 0, '2025-12-20 16:01:51.795816', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('b49ac03e-514e-46cc-b297-f5a2b53282d4', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 5, '2025-12-20 16:01:52.127741', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f85a8871-38c7-4ee4-aac2-f9f143dfe83e', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', NULL, NULL, 6, '2025-12-20 16:02:04.852384', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('8c22e791-7521-44c6-b3c3-b8fe1afeeffd', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', NULL, NULL, 6, '2025-12-20 16:02:05.825114', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('31c4df54-a6d5-4328-8f0b-31c595ffbe77', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 6, '2025-12-20 16:02:06.429069', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('13be336f-11bf-461c-b290-71c7aa0abb11', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', NULL, NULL, 6, '2025-12-20 16:02:06.845159', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0e1078b2-11f9-4cd8-b24f-448b15ed3cd8', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', NULL, NULL, 6, '2025-12-20 16:02:07.340576', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('199fa695-f933-487c-8775-9f9b1da047e3', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', NULL, NULL, 6, '2025-12-20 16:02:08.49194', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('55a5c946-d3bd-40fe-8a3b-afc879f2e1d0', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', NULL, NULL, 6, '2025-12-20 16:02:08.727733', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('da8a1566-5698-4048-b234-cf00f044ee10', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 6, '2025-12-20 16:02:09.880513', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0c6f8a43-54cc-4a98-bd1d-41e9bf83972d', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', NULL, NULL, 6, '2025-12-20 16:02:12.072708', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('d6932184-a562-4d6d-806e-14ba549559cb', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 6, '2025-12-20 16:02:12.859199', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('97577717-3863-4ebc-99d4-6aaf882a6e98', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', NULL, NULL, 6, '2025-12-20 16:02:14.97558', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('65868450-5f13-4d87-b8ab-6d8ee2e17c52', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 6, '2025-12-20 16:02:17.793548', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('1688a2d3-3875-4846-9941-18182a61193f', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', NULL, NULL, 6, '2025-12-20 16:02:42.703098', 1, 'Clara Oswald', 'Mise à jour des informations du contact'),
	('c48689c9-d5e5-4919-8b1b-90613e9ba6af', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', NULL, NULL, 2, '2025-12-20 16:02:42.703981', 1, 'Clara Oswald', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('33d3e213-afa9-4b65-b517-bc31c657c5dc', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', 'flavie.mehn4@gmail.com', '1998-03-02', 6, '2025-12-20 16:03:51.327426', 1, 'Flavie Mehn', 'Mise à jour des informations du contact'),
	('d277aca5-8c5b-4e4b-8dee-be5a69fe7778', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', 'flavie.mehn4@gmail.com', '1998-03-02', 2, '2025-12-20 16:03:51.32897', 1, 'Flavie Mehn', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('400d814f-02a7-4414-b3d7-1ca92bc0152a', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', 'arthur.brugnano@free.fr', '2000-07-14', 6, '2025-12-20 16:05:39.930136', 1, 'Arthur Brugnano', 'Mise à jour des informations du contact'),
	('6ec867f1-9dd8-4562-8e62-be652843a169', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', 'arthur.brugnano@free.fr', '2000-07-14', 2, '2025-12-20 16:05:39.931017', 1, 'Arthur Brugnano', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('4d1e2d4b-0ddf-4489-a0fd-0493b823f8b3', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', 'fantine.charbo@gmail.com', '2001-10-25', 6, '2025-12-20 16:07:21.076199', 1, 'Fantine Charbonniere', 'Mise à jour des informations du contact'),
	('fbc67b0f-5b73-4b54-bab5-580262502c0f', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', 'fantine.charbo@gmail.com', '2001-10-25', 2, '2025-12-20 16:07:21.076938', 1, 'Fantine Charbonniere', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('90d14138-4e72-48d7-91f6-3a61df10fa6c', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', 'vott1984@gmail.com', '1984-01-01', 6, '2025-12-20 16:11:59.833568', 1, 'Vincent Ott', 'Mise à jour des informations du contact'),
	('906f6aba-b63e-4a01-bc1d-854d715118e7', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', 'vott1984@gmail.com', '1984-01-01', 2, '2025-12-20 16:11:59.835144', 1, 'Vincent Ott', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('ee9f0c04-749c-477c-a23b-37f7c61fa6f4', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', 'florentaymeric@yahoo.com', NULL, 6, '2025-12-20 16:12:51.193257', 1, 'Aymeric Florent', 'Mise à jour des informations du contact'),
	('94a343ae-a481-40dc-a1ec-37bbf7b2b5a7', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', 'florentaymeric@yahoo.com', NULL, 2, '2025-12-20 16:12:51.194261', 1, 'Aymeric Florent', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d62c2e4f-ddd5-4b5f-b352-06ec76bc0f79', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', 'thomas.pfister84@gmail.com', '1984-11-11', 6, '2025-12-20 17:11:48.284087', 1, 'Thomas Pfister', 'Mise à jour des informations du contact'),
	('190795f2-77da-4251-a797-79afcacae1f6', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', 'thomas.pfister84@gmail.com', '1984-11-11', 2, '2025-12-20 17:11:48.285042', 1, 'Thomas Pfister', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('dae7b67f-8e50-4f1b-b220-0566cb127c87', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', 'remiwatrin@gmail.com', '1989-12-27', 6, '2025-12-22 08:46:26.536264', 1, 'Remi Watrin', 'Mise à jour des informations du contact'),
	('a93451bd-7ef3-4ff5-8ef2-adfebe623e22', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', 'remiwatrin@gmail.com', '1989-12-27', 2, '2025-12-22 08:46:26.540255', 1, 'Remi Watrin', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('44490717-1c44-4937-a72a-269765a8e050', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 5, '2025-12-26 18:17:01.586374', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d3143b01-661a-4815-9ea7-438d646d7da8', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', NULL, NULL, 5, '2025-12-26 18:17:01.976887', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('108f8d12-b10d-4f6b-82e1-bd55875d587f', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', NULL, NULL, 5, '2025-12-26 18:17:02.301721', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d6dca18c-b376-44db-b618-548ff689bdfa', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', NULL, NULL, 5, '2025-12-26 18:17:02.630095', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1ccc4fa3-d55a-4242-aaa7-b108e98a2104', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 6, '2025-12-26 18:17:34.258', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9b0f79ec-2579-4ff4-9984-9526262227ca', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', NULL, NULL, 5, '2025-12-26 18:17:02.95717', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('8aec8de1-c6ad-4ffb-84fd-66d096a4f198', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', NULL, NULL, 5, '2025-12-26 18:17:03.267032', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('5ae23cc9-280c-4daa-82d4-07c04c536989', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 5, '2025-12-26 18:17:03.909699', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('35fb4f66-9ebd-4212-8042-e65cd929960c', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 5, '2025-12-26 18:17:04.223534', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f0d6f019-49ea-41f5-814f-bac4d266c414', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 5, '2025-12-26 18:17:04.538378', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('c71cfe5e-ed82-43dd-92f8-dc4b50ed62e5', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', NULL, NULL, 5, '2025-12-26 18:17:05.163166', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('6ff11f8f-9480-4dd2-905b-20201dfd3b30', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', NULL, NULL, 5, '2025-12-26 18:17:05.805317', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ada826b8-ab76-4f1e-8b14-b79e5bcd49c3', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 5, '2025-12-26 18:17:06.44553', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('a3d8111c-3360-436d-af26-6fd9696ced7c', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 5, '2025-12-26 18:17:06.759566', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('47917733-d620-4f77-856e-3296625469ff', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 5, '2025-12-26 18:17:07.06336', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('7f244deb-c364-4d4c-90d8-7407d0b1ec38', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', NULL, NULL, 5, '2025-12-26 18:17:07.569253', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('34ac4935-f0e1-4fcb-963a-c272af70f903', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 5, '2025-12-26 18:17:07.867121', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2ec5370e-4a8c-4036-9786-d931701fcadb', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 5, '2025-12-26 18:17:08.358296', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ee9cc96f-3a3a-4405-958b-ab4b0c47e5da', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 5, '2025-12-26 18:17:08.664', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('136f3202-f108-40e6-93a2-567af9900c76', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 5, '2025-12-26 18:17:08.956375', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0aa916a4-f928-4fcc-a301-8800595437c9', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 5, '2025-12-26 18:17:10.69429', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1fa13264-c50d-4355-98ec-b3d6e4e4e78f', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 5, '2025-12-26 18:17:11.481837', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('3781de34-5abf-46f2-a5be-f01ad0f7b5d0', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 5, '2025-12-26 18:17:11.96519', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('7e28b47a-210c-4851-904f-5b04c8d60092', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 5, '2025-12-26 18:17:12.273392', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('71d950dd-5374-4607-a282-1f79bc709900', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 5, '2025-12-26 18:17:13.149272', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('b29957a9-3dd4-4789-a579-78c9d56443c4', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 5, '2025-12-26 18:17:13.448248', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('157747ba-a2da-41d9-a0d8-d259affeb56e', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 5, '2025-12-26 18:17:13.942638', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f447533b-3f97-40b4-9689-10b199e6995f', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 5, '2025-12-26 18:17:14.223752', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('164ce322-b9d1-433f-9e4d-952ef472a1b1', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 5, '2025-12-26 18:17:14.524415', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('998b4ae5-8290-4633-ad1d-947be439db0a', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 5, '2025-12-26 18:17:14.817712', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('411ac722-6e80-429b-88c3-4376f6daa4a2', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, NULL, 5, '2025-12-26 18:17:15.095571', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('3f5517a9-a417-4925-88fa-1f78d7234981', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 5, '2025-12-26 18:17:15.391866', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ce027886-5d57-46bc-9225-fc658ab6b905', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 5, '2025-12-26 18:17:15.879834', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('4692ad09-52b8-4c9e-a83f-1a97ff502774', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 5, '2025-12-26 18:17:16.355849', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('52d8af44-26ec-42c7-8a9a-31016ce0e9a5', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 5, '2025-12-26 18:17:16.633417', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ec212a83-2195-4c42-821f-440bd617ac0b', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 5, '2025-12-26 18:17:17.101678', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('3bf0af11-8caf-44f0-af80-8483bb68cb15', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 5, '2025-12-26 18:17:17.384787', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('acdb0164-de11-4f8c-9676-e82e625fbd7b', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 5, '2025-12-26 18:17:17.971906', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ea6a5d4c-6bbc-4e56-8a7f-0f126835926c', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 5, '2025-12-26 18:17:18.278901', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('89aeae5a-e905-47a0-890b-b357b0a15038', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 5, '2025-12-26 18:17:19.026979', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ca11da98-b1c0-48ef-8164-1ab1a5896243', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', NULL, NULL, 4, '2025-12-26 18:17:19.603718', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('4c79eb9c-ccf2-49d1-af58-d4a0fb7405d3', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 5, '2025-12-26 18:17:19.883017', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0ff5822f-7156-4ef0-87e7-0426d1416fbd', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 5, '2025-12-26 18:17:20.185151', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('65c55df6-b809-4396-9d45-455478047ced', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 5, '2025-12-26 18:17:20.503584', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('aff7aa14-74cf-40fc-8f2b-0322fcd20561', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 5, '2025-12-26 18:17:21.313955', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('11488236-6362-4095-a53b-cf7e07a9df8e', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 5, '2025-12-26 18:17:21.622186', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('67c4a7b8-c151-41a8-95f5-97062c65c858', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 5, '2025-12-26 18:17:21.917729', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('d3bfe074-0529-48a8-a0ab-5671d59afab0', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 5, '2025-12-26 18:17:22.702082', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('1bbd0994-a688-4f23-97fb-10ded5577b41', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 5, '2025-12-26 18:17:23.007368', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('3801c9bc-ccec-4899-a47d-e1e578c4d353', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 5, '2025-12-26 18:17:23.4882', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('ea5987f7-801f-4033-b9ff-7264d5e01933', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 5, '2025-12-26 18:17:24.236229', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('045d550c-2c0a-42d4-a8c8-1faa7548b3ce', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 5, '2025-12-26 18:17:24.514247', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('5e7c57ec-cd4f-4927-a49e-8a96ac847e5f', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 5, '2025-12-26 18:17:25.131341', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2d8bf445-39a8-43de-a097-e8cde7c29f5a', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 5, '2025-12-26 18:17:25.418964', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('74c7cd4f-2f69-4e2c-b4b1-40513d463472', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 5, '2025-12-26 18:17:25.720607', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f0c1cdd2-b7cc-40b4-b19d-ad9f9018add4', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 5, '2025-12-26 18:17:26.19867', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('fef280d7-492d-4436-8fce-32df4703d4a7', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 5, '2025-12-26 18:17:26.679045', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('bc143d5d-5318-4299-b095-c2a0cd168e32', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 5, '2025-12-26 18:17:27.150429', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('2f313a36-b343-4fea-9e95-b6c06096b848', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', NULL, NULL, 6, '2025-12-26 18:17:29.099328', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('33828c8b-b614-4338-bc12-df2cc57bfe27', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 6, '2025-12-26 18:17:29.269214', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('2185ed09-b1b9-4846-b4c3-a2c01726dfc2', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 6, '2025-12-26 18:17:29.468861', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e6012aec-05fb-45fd-97f9-11911ed4ffc5', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', NULL, NULL, 6, '2025-12-26 18:17:29.764557', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f7b99e6e-0d3d-4b15-88fa-e168082527c7', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 6, '2025-12-26 18:17:29.868081', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c2bab89a-27c1-4b51-8247-f078f0db9261', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 6, '2025-12-26 18:17:31.152644', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e904847c-d87c-4829-82cf-24c53711eb33', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', NULL, NULL, 6, '2025-12-26 18:17:31.663599', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('a5162a9c-19b2-4d83-a6ae-a01e6e16fb95', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', NULL, NULL, 6, '2025-12-26 18:17:32.266979', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('77333ab2-7965-40e2-a11a-63f586a4048a', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 6, '2025-12-26 18:17:32.839735', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('18283e34-f54a-4e45-b139-25d650d1c18d', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', NULL, NULL, 6, '2025-12-26 18:17:33.503543', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('41a75810-0ddf-4e5b-9184-39d155df877e', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', NULL, NULL, 6, '2025-12-26 18:17:34.66568', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('bf0a50bd-fe09-40f4-9218-8efbb5bf725d', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, NULL, 6, '2025-12-26 18:17:35.320874', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f431ab8f-10a0-4470-96b1-5d2bbdabbe31', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 6, '2025-12-26 18:17:36.493967', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('654c7d2e-053a-4cac-8da9-ca4586a59ab5', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', NULL, NULL, 6, '2025-12-26 18:17:36.553773', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('fa06eeb4-da6b-4945-8457-b4edc0c2b5ec', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 6, '2025-12-26 18:17:37.600648', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('2c9da6b7-5db3-45e2-b45d-e70161baa788', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 6, '2025-12-26 18:17:38.19329', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('da387a7f-c7e5-4008-8ca1-ba5a8eeec249', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', NULL, NULL, 6, '2025-12-26 18:17:39.468806', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e5f06f2b-bb61-4cfe-8ecc-ec01eac4f10d', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 6, '2025-12-26 18:17:40.076888', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0d78e77d-c5c4-4e10-ae9d-b309d07b6fb3', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 6, '2025-12-26 18:17:40.403202', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ea4dd89d-d0f8-4abc-829b-8c38e6bc3cf8', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 6, '2025-12-26 18:17:41.295602', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('3a0beda9-2446-430c-b90c-5a29bc78703e', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', NULL, NULL, 6, '2025-12-26 18:17:41.441457', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c3a579db-f721-4671-8354-2e4783482d39', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', NULL, NULL, 6, '2025-12-26 18:17:42.131619', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('dd07f2e4-1214-4613-ac0e-b81c425682fc', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 6, '2025-12-26 18:17:43.370044', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('d56a9796-16d0-4896-a2d5-1705899b9631', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 6, '2025-12-26 18:17:44.529194', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('b8191da4-ea8f-4e0b-a401-1223678fd26a', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 6, '2025-12-26 18:17:44.638717', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('37f8e1ea-722f-4aaf-a901-9b83111f7af4', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 6, '2025-12-26 18:17:44.729075', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('319366ca-8c23-4506-851d-70d551281333', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 6, '2025-12-26 18:17:44.746896', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0990432b-f16f-44b0-a5ae-367b13102304', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', NULL, NULL, 6, '2025-12-26 18:17:45.16934', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('8e01b750-6f75-428a-93d7-400f0b713e45', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 6, '2025-12-26 18:17:46.088773', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('3b135b60-69df-48af-9eb9-4c03cd4015f2', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 6, '2025-12-26 18:17:46.116267', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('e1cb0a34-778b-43b4-8f00-f4aeb8203101', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 6, '2025-12-26 18:17:46.849802', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('34c7cf8d-1f1d-4476-8b3a-a732f74eee73', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 6, '2025-12-26 18:17:46.920429', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('72179f40-71ec-4a69-b690-54d437385d0c', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, NULL, 6, '2025-12-26 18:17:47.778791', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('33dcc089-f9bd-4c28-9a54-b107d2a65df2', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 6, '2025-12-26 18:17:48.742571', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('527a32ca-8666-450b-9ed0-d523012de25a', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', NULL, NULL, 6, '2025-12-26 18:17:48.993472', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('55f13887-58a8-4c0d-a43b-be60aa8122d6', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 6, '2025-12-26 18:17:50.093499', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('6c5e03d7-d181-4af8-85f4-dae79a7fc1aa', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', NULL, NULL, 6, '2025-12-26 18:17:51.369948', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('edc6fd73-07a9-42d3-858f-b23c3c42e97b', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', NULL, NULL, 6, '2025-12-26 18:17:52.183749', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c8bf9f49-c8e4-43e7-a3a2-f57ce2d4f7e1', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 6, '2025-12-26 18:17:52.264063', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('638eb09a-1162-4ba3-b7b7-f100213991be', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', NULL, NULL, 6, '2025-12-26 18:17:54.256937', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('c5825e0b-d0f7-497f-88f6-471c1680669b', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 6, '2025-12-26 18:17:55.330105', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0f83cd02-deb3-42de-b9b9-4f4ab130de7f', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 6, '2025-12-26 18:17:56.012321', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('542d0c7e-ce63-44bd-8ef0-a19f5c0b9b82', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', NULL, NULL, 6, '2025-12-26 18:17:57.254698', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('5bad007f-9c7c-4f4f-bc14-240aa5cfb51f', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', NULL, NULL, 6, '2025-12-26 18:17:57.358883', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('3861e2c8-1782-4968-b2d3-c848a23c15dd', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 6, '2025-12-26 18:18:02.404547', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('73a78073-a3d8-497b-99c1-1e3644205d5b', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 6, '2025-12-26 18:17:38.96117', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('2ea83f50-e705-452f-96b5-05a3abe64ea9', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', NULL, NULL, 6, '2025-12-26 18:17:42.299364', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f6037204-f929-4ec7-899b-99d2a740aa7e', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', NULL, NULL, 6, '2025-12-26 18:17:46.623217', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('1d54ccba-c5fe-49c5-be8d-f56424e159a9', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 6, '2025-12-26 18:17:50.463637', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('5f6dc547-3329-4bd3-bab3-aa70c8a4252a', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 6, '2025-12-26 18:17:53.973298', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('36d16646-d546-4a53-a640-c64db1eb3e4a', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', NULL, NULL, 6, '2025-12-26 18:18:03.269431', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('f4e6763f-07a1-4f4f-9fdb-2ca4b205a811', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', NULL, NULL, 6, '2025-12-26 18:18:06.48226', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('7384bbfe-9d10-480e-8acd-e90efabad4b5', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 6, '2025-12-26 18:18:10.146678', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('19aeb943-a7bb-4b12-a99f-7eafc71ddf83', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 6, '2025-12-26 18:18:12.867364', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('a1e96f8b-004e-4b6b-95ae-127aa44167b3', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 6, '2025-12-26 18:18:14.789602', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('faef312d-9aa9-4c9d-bcd2-1352209d2d9c', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', 'jipize@gmail.com', '1991-08-13', 6, '2025-12-26 18:19:03.127267', 1, 'Jean-philippe MALL', 'Mise à jour des informations du contact'),
	('2997b685-9f54-4e9c-ab7d-2696e0ee8269', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', 'jipize@gmail.com', '1991-08-13', 2, '2025-12-26 18:19:03.12829', 1, 'Jean-philippe MALL', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('b31db9b9-078b-48d1-821c-a1c0b1b68701', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', 'mbam67@gmail.com', '1984-08-05', 5, '2025-12-26 18:19:13.266835', 1, 'Mounir Mohamed Ben Ali', 'Mise à jour des informations du contact'),
	('6895dfde-7682-4a7d-be16-1bf27b8b5baf', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', 'mbam67@gmail.com', '1984-08-05', 2, '2025-12-26 18:19:13.267454', 1, 'Mounir Mohamed Ben Ali', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c34d4176-3275-4b47-8aaa-60104f840810', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', 'guytoutcc@gmail.com', '1969-12-06', 5, '2025-12-26 18:20:27.225131', 1, 'Guy Bischof', 'Mise à jour des informations du contact'),
	('b98ca541-de42-4994-b261-5df85ec6bb88', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', 'guytoutcc@gmail.com', '1969-12-06', 2, '2025-12-26 18:20:27.226208', 1, 'Guy Bischof', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1a2e4d92-c69b-42ef-9574-dc7bd0ec54ad', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 6, '2025-12-26 18:21:12.496201', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('8a7eb78b-7f7c-48bf-a524-8a840c8576da', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', 'pat.wagen@hotmail.fr', '1985-06-19', 6, '2025-12-26 18:21:18.160483', 1, 'Patrice Wagentrutz', 'Mise à jour des informations du contact'),
	('2bcfa21c-1667-477d-acd0-daa2e6e94b7d', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', 'pat.wagen@hotmail.fr', '1985-06-19', 2, '2025-12-26 18:21:18.161338', 1, 'Patrice Wagentrutz', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('8aaa3019-a601-4ad9-85eb-b6e78672560a', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', 'kevin.beretta7@gmail.com', '1990-05-18', 6, '2025-12-26 18:21:37.820011', 1, 'Kévin Beretta', 'Mise à jour des informations du contact'),
	('9c0a1d10-0832-4fdd-8831-6b9e135a2c75', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', 'kevin.beretta7@gmail.com', '1990-05-18', 2, '2025-12-26 18:21:37.820575', 1, 'Kévin Beretta', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('221ddedb-e0e9-4bab-8bce-23bb3780de99', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', 'af.andres.fabrice@gmail.com', '1973-01-10', 6, '2025-12-26 18:22:11.820388', 1, 'Fabrice Andres', 'Mise à jour des informations du contact'),
	('9fae7724-17fc-4a7a-bde1-fccfc519310a', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', 'af.andres.fabrice@gmail.com', '1973-01-10', 2, '2025-12-26 18:22:11.821125', 1, 'Fabrice Andres', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('aa20719d-0298-4192-84f1-0f95a9a465fc', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', 'eve.bacci@hotmail.fr', '1995-03-21', 6, '2025-12-26 18:23:28.542547', 1, 'Eve Bacci', 'Mise à jour des informations du contact'),
	('e2e13a16-091f-4ad8-ba51-d6ad083ec3b9', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', 'eve.bacci@hotmail.fr', '1995-03-21', 2, '2025-12-26 18:23:28.543156', 1, 'Eve Bacci', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('274790bd-3969-4325-8f9f-ae3d485dcd01', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 6, '2025-12-26 18:23:52.263331', 1, 'Jérôme  Fritsch ', 'Mise à jour des informations du contact'),
	('76f889b4-03e1-42ac-89a4-2683ae528489', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', NULL, '1984-04-01', 2, '2025-12-26 18:23:52.265565', 1, 'Jérôme  Fritsch ', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('46b87862-7f3b-4ea5-a42c-45a0dfc2e50f', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', 'n.metzger1720@gmail.com', '1997-11-19', 6, '2025-12-26 18:24:08.976307', 1, 'Nicolas Metzger', 'Mise à jour des informations du contact'),
	('60f6d24e-8d17-4970-93b3-f003a661ba91', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', 'n.metzger1720@gmail.com', '1997-11-19', 2, '2025-12-26 18:24:08.9769', 1, 'Nicolas Metzger', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('739f6fc3-a326-48dd-a1eb-29123e568986', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 6, '2025-12-26 18:29:11.646297', 1, 'Myngoc Tu', 'Mise à jour des informations du contact'),
	('371779b8-26be-4667-bf81-337e12c73a18', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', NULL, NULL, 2, '2025-12-26 18:29:11.6468', 1, 'Myngoc Tu', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d1f9fa62-c132-4f7e-85d4-a8ac4ea91da9', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 6, '2025-12-26 18:30:56.967946', 1, 'Marion Ott', 'Mise à jour des informations du contact'),
	('d23d3c92-fa24-461e-87be-755ea5c48723', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', NULL, NULL, 2, '2025-12-26 18:30:56.968423', 1, 'Marion Ott', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('02f40de1-ea70-4c38-ac70-c360569cf72b', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, '1991-10-08', 6, '2025-12-26 18:37:53.703401', 1, 'Adeline Blanc', 'Mise à jour des informations du contact'),
	('80ff59dd-9bc4-42d7-94dd-2ad4bddd50b4', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', NULL, '1991-10-08', 2, '2025-12-26 18:37:53.703946', 1, 'Adeline Blanc', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('2f6f8a64-124c-4531-804d-e689fe1f3274', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'gergonzales@wanadoo.fr', '1979-06-24', 5, '2025-12-26 18:54:21.607514', 1, 'Sandra Ringenbach', 'Mise à jour des informations du contact'),
	('e699a4ef-09e4-4f40-b548-039d1b252917', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'gergonzales@wanadoo.fr', '1979-06-24', 2, '2025-12-26 18:54:21.608431', 1, 'Sandra Ringenbach', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('fd9617bf-0ce0-4499-8283-54fac1e889a4', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, '1991-12-10', 6, '2025-12-26 19:00:05.448061', 1, 'Étienne Borges', 'Mise à jour des informations du contact'),
	('f24927b1-c1af-4e3e-9d7d-bede0c28132e', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', NULL, '1991-12-10', 2, '2025-12-26 19:00:05.449246', 1, 'Étienne Borges', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('84fab2d3-d04e-4c70-9166-c537740d1748', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', 'walfroy.meunier@laposte.net', '1991-04-07', 5, '2025-12-26 19:11:32.085413', 1, 'Walfroy MEUNIER', 'Mise à jour des informations du contact'),
	('d499f03c-476c-4f3e-9d9b-d712c06fb6bf', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', 'walfroy.meunier@laposte.net', '1991-04-07', 2, '2025-12-26 19:11:32.087013', 1, 'Walfroy MEUNIER', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('aa9d2179-89bd-44e5-9a13-afb4df167983', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', 'stefi_bp@hotmail.com', '1983-10-11', 6, '2025-12-26 19:31:28.340303', 1, 'Stéphanie Gwen Hubscher', 'Mise à jour des informations du contact'),
	('1859499a-e5d4-4ada-a36a-44225ff9ebb3', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', NULL, NULL, 0, '2026-01-06 19:53:23.83386', 0, 'Anonyme', 'Enregistrement initial'),
	('9a6028d3-d805-4161-b406-f48356a54dcc', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', 'stefi_bp@hotmail.com', '1983-10-11', 2, '2025-12-26 19:31:28.341086', 1, 'Stéphanie Gwen Hubscher', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('d60f9f31-f75e-4a10-9be2-83192933c71b', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', 'claire.manigold@hotmail.fr', '1991-04-25', 5, '2025-12-26 19:41:29.796347', 1, 'Claire Manigold', 'Mise à jour des informations du contact'),
	('a8590272-d9e4-4fa0-bc41-238c863c97ba', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', 'claire.manigold@hotmail.fr', '1991-04-25', 2, '2025-12-26 19:41:29.797374', 1, 'Claire Manigold', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('dc52ff2f-530b-4df9-a138-d7ec23ac4d79', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', 'isabelle.karjouck@icloud.com', '1981-08-24', 6, '2025-12-26 20:35:38.973881', 1, 'Isabelle Karjouck', 'Mise à jour des informations du contact'),
	('cab732e3-142d-40d0-8125-c6e1cffcf16d', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', 'isabelle.karjouck@icloud.com', '1981-08-24', 2, '2025-12-26 20:35:38.975067', 1, 'Isabelle Karjouck', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('3f11cb4e-6cfb-419e-8bd4-d50028cb5ff3', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', NULL, NULL, 2, '2025-12-26 20:42:01.831664', 1, 'Lucas Wagner', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('179ecc8c-fb9a-40f1-91d0-4b28b89f5211', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', NULL, NULL, 5, '2025-12-26 20:54:28.734626', 2, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('2023116e-30d0-49b8-ae61-3a5b7d660c22', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', 'mathwbu@gmail.com', '1974-01-25', 6, '2025-12-26 22:01:15.42879', 1, 'Mathieu Weibel', 'Mise à jour des informations du contact'),
	('3ecfe661-4df0-49f4-877e-8cf438af00e1', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', 'mathwbu@gmail.com', '1974-01-25', 2, '2025-12-26 22:01:15.429973', 1, 'Mathieu Weibel', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('1655c45c-704e-4c26-842c-8bb65e13b4f9', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', 'viny.k67@gmail.com', '1981-05-09', 6, '2025-12-26 22:37:46.759231', 1, 'Virginie Kohler', 'Mise à jour des informations du contact'),
	('3df486e3-a734-4326-a807-3aca6031729f', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', 'viny.k67@gmail.com', '1981-05-09', 2, '2025-12-26 22:37:46.759898', 1, 'Virginie Kohler', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('7b6dce18-0feb-458f-9cb1-f4ab10110949', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', 'adrienjacob85@gmail.com', '1985-06-17', 5, '2025-12-27 00:28:32.870505', 1, 'Adrien Jacob', 'Mise à jour des informations du contact'),
	('fc1116a2-58f7-4095-9498-aa18bafed317', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', 'adrienjacob85@gmail.com', '1985-06-17', 2, '2025-12-27 00:28:32.871484', 1, 'Adrien Jacob', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('8b9aef37-1004-4b66-9191-0fa24b9e8e19', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', 'francois_goetzmann@yahoo.fr', '1988-02-10', 5, '2025-12-27 06:31:28.935083', 1, 'François Goetzmann', 'Mise à jour des informations du contact'),
	('98fe5950-68b3-4cd2-a40a-b494a7f8f2b8', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', 'francois_goetzmann@yahoo.fr', '1988-02-10', 2, '2025-12-27 06:31:28.935745', 1, 'François Goetzmann', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('0ff737da-4c39-4867-83cd-d61169e80ebc', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', 'fwiedemann123@gmail.com', '1995-01-02', 6, '2025-12-27 08:51:54.140531', 1, 'Florian  Wiedmann', 'Mise à jour des informations du contact'),
	('96e1bd68-4f8b-49eb-a8fe-80ce6600a692', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', 'fwiedemann123@gmail.com', '1995-01-02', 2, '2025-12-27 08:51:54.141499', 1, 'Florian  Wiedmann', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('4873b765-e75b-4f84-885b-9dcd8c4145f1', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', NULL, NULL, 2, '2025-12-27 09:33:10.936806', 1, 'Sébastien Narducci', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('333ae246-77f0-4702-ad3a-2df0f31898de', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', 'nadine.balla@sft.fr', '1978-04-07', 6, '2025-12-27 12:44:17.040137', 1, 'Nadine Jordan ', 'Mise à jour des informations du contact'),
	('14df8b90-9557-49cd-8bd4-1afba935a6d7', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', 'nadine.balla@sft.fr', '1978-04-07', 2, '2025-12-27 12:44:17.041124', 1, 'Nadine Jordan ', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('fe900b8c-1652-4cf9-888a-4fbe2d85c900', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', 'Cheima.gharbif@gmail.com', '1992-06-26', 6, '2025-12-27 20:28:19.229984', 1, 'Cheima Gharbi', 'Mise à jour des informations du contact'),
	('834f325a-3a7f-4e01-966c-ef3896bb267d', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', 'Cheima.gharbif@gmail.com', '1992-06-26', 2, '2025-12-27 20:28:19.230862', 1, 'Cheima Gharbi', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('b8f580b1-6fe3-4910-943b-9c627df25e66', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', 'my.tu1988@outlook.fr', '1988-07-22', 2, '2025-12-28 17:09:43.309749', 1, 'My Duyen Tu', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('9ca53157-9cb6-443d-bc81-feed9e359f82', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', NULL, NULL, 2, '2025-12-28 18:00:27.102825', 1, 'ASHS BOT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('58c5601e-8b68-4ed0-8d8f-0c627be406b7', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 6, '2025-12-28 18:33:36.847297', 1, 'Quentin Mitoire', 'Mise à jour des informations du contact'),
	('0a189b06-f513-4396-b42d-4c767deb0abb', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', NULL, NULL, 2, '2025-12-28 18:33:36.848545', 1, 'Quentin Mitoire', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('f88a15be-7abd-4188-8946-196f18941a52', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 6, '2025-12-28 19:27:41.348281', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('140cc452-6ac0-473b-9f7a-fada067e0a85', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', 'fantine.charbo@gmail.com', '2001-10-25', 2, '2025-12-28 21:47:33.702798', 1, 'Fantine Charbonniere', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('51d0422a-9670-46ba-897d-2f5c9e7bf76f', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'gergonzales@wanadoo.fr', '1979-06-24', 2, '2025-12-29 09:41:25.959703', 1, 'Sandra Ringenbach', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('4ce62e15-5eea-4ff4-b8b8-511b591dd64f', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', 'flavie.mehn4@gmail.com', '1998-03-02', 2, '2025-12-29 10:24:12.37429', 1, 'Flavie Mehn', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('66407f7e-9183-4abf-a347-95bf884989cc', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', 'arthur.brugnano@free.fr', '2000-07-14', 2, '2025-12-29 10:25:47.008859', 1, 'Arthur Brugnano', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('21f1c6d2-fa6b-4ddb-a620-74fc6ac7ebd2', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', 'fantine.charbo@gmail.com', '2001-10-25', 2, '2025-12-29 19:47:35.668064', 1, 'Fantine Charbonniere', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6b635c53-d13f-4a54-84ec-a1e5d4a0d285', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, '1976-02-12', 6, '2025-12-30 13:36:17.947056', 1, 'Vivien Gross', 'Mise à jour des informations du contact'),
	('df50330f-b8cb-46f6-91c7-f55a00f9addb', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', NULL, '1976-02-12', 2, '2025-12-30 13:36:17.948259', 1, 'Vivien Gross', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('026cebad-ecef-4a0f-8304-899ab9864cf9', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', NULL, NULL, 2, '2026-01-01 10:52:03.565492', 1, 'ASHS BOT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('551dc2b9-f225-402d-a369-10b73c221fe1', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', NULL, NULL, 2, '2026-01-01 10:55:26.513338', 1, 'ASHS BOT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('eb91de14-9a93-475c-ad2d-28b36a38a4f8', '16271680-19a8-4184-a754-337364221875', '+33673426632', NULL, NULL, 4, '2026-01-01 11:17:39.424453', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('ca752029-018d-4daa-850f-890efcff639c', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', NULL, NULL, 4, '2026-01-01 11:17:39.49403', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('dc7e7ef4-994e-40aa-b653-8a66e9a19cca', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', NULL, NULL, 4, '2026-01-01 11:17:39.504076', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('0dd4bdd2-766f-4946-9a08-510b708a4607', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', NULL, NULL, 4, '2026-01-01 11:17:39.512222', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('76b5d0aa-223c-4f05-8488-724c076a4a6b', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', NULL, NULL, 4, '2026-01-01 11:17:39.521292', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('84d940bb-3d1d-45df-b90a-9de707df77c8', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', NULL, NULL, 4, '2026-01-01 11:17:39.534129', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('4faeb33a-c249-402e-aeaa-82b71da026be', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', NULL, NULL, 4, '2026-01-01 11:17:39.5447', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('d9157881-4da3-463f-855e-a12d98b6699f', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', NULL, NULL, 4, '2026-01-01 11:17:39.563528', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('ae9a2cc8-d20e-4704-8eae-75156791ce0f', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', NULL, NULL, 4, '2026-01-01 11:17:39.573449', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('e96ef55e-bfad-4d08-b97e-4534c29f906f', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', NULL, NULL, 4, '2026-01-01 11:17:39.582693', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('8bc13b00-1418-415b-8c6e-2eefa81369a0', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', NULL, NULL, 4, '2026-01-01 11:17:39.591299', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('4bd20862-72a5-4453-adaa-1ad1b5013a66', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', NULL, NULL, 4, '2026-01-01 11:17:39.600513', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('1d29b212-0ac8-4b01-ac5d-289f19437046', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', NULL, NULL, 4, '2026-01-01 11:17:39.610041', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('18064171-a912-47d7-b4c2-180ae7d806cf', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', NULL, NULL, 4, '2026-01-01 11:17:39.618529', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('e3a7fc6b-7adb-4060-b8ef-2f270752f435', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', NULL, NULL, 4, '2026-01-01 11:17:39.626601', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('ef53fa70-45de-4dfe-85e1-48f0e33137a0', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', NULL, NULL, 4, '2026-01-01 11:17:39.638356', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('d64c73ee-2dc2-442d-8231-ccc4fbf7777e', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', NULL, NULL, 4, '2026-01-01 11:17:39.6479', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('68c51bf3-abc5-4d40-b791-9c1167f29df4', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', NULL, NULL, 4, '2026-01-01 11:17:39.661856', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('f4c2532b-9f72-4565-b1de-14748932e219', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', NULL, NULL, 4, '2026-01-01 11:17:39.674056', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('2ea82c95-a963-4776-a05e-d9511a91814c', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', NULL, NULL, 4, '2026-01-01 11:17:39.687575', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('56cd0f5f-27c9-4a1f-b4a3-f3a9d67f3e08', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', NULL, NULL, 4, '2026-01-01 11:17:39.701961', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('c113d7ee-6b0b-454e-809d-84617aaf6bf1', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', NULL, NULL, 4, '2026-01-01 11:17:39.70956', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('902f76e0-a4c4-4008-9417-cb4dc7662e24', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', NULL, NULL, 4, '2026-01-01 11:17:39.716652', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('d0bbac14-d93f-47be-b0d8-7e606772cd3e', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', NULL, NULL, 4, '2026-01-01 11:17:39.723656', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('56b5b4f5-dd28-41e3-86e1-618064359ed1', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 5, '2026-01-01 11:17:40.465776', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('717a0cd2-0cb4-41d8-b840-60494c017ee0', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', NULL, NULL, 4, '2026-01-01 11:17:40.485628', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('0835c321-4fb7-4768-89c2-265a7e6e9268', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', NULL, NULL, 4, '2026-01-01 11:17:40.497166', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('070de47b-a2b2-4ddd-ab0d-84a451b5882e', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 5, '2026-01-01 11:17:40.815147', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('3920691a-e0df-4b00-bf5d-42fe79558fb5', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', NULL, NULL, 4, '2026-01-01 11:17:40.825731', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('4f62ac5d-a640-4924-b810-5e65851aeb61', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 5, '2026-01-01 11:17:41.147769', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('59592aec-067d-4f69-8329-5f059af959d5', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', NULL, NULL, 4, '2026-01-01 11:17:41.157677', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('e08c3d44-e1c0-4c1d-9b17-fb136c94d8e3', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', NULL, NULL, 4, '2026-01-01 11:17:41.168611', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('4139fab4-24f8-46e0-926c-ba49e42adc10', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', NULL, NULL, 4, '2026-01-01 11:17:41.185329', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('026da0be-11fe-4168-9da1-99ad197b4b35', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', NULL, NULL, 4, '2026-01-01 11:17:41.192674', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('a1947c8e-5ee0-4c07-9b00-01c8909d1a3b', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', NULL, NULL, 4, '2026-01-01 11:17:41.200002', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('ef759aea-d457-4c68-b046-d872a7fd0878', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 5, '2026-01-01 11:17:41.52351', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('64b7122d-43a7-41d0-bdbd-8ff5151fadab', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', NULL, NULL, 4, '2026-01-01 11:17:41.532437', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('0f36334f-f2df-4ba6-9619-350efb45b827', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 5, '2026-01-01 11:17:41.842705', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('236eee1f-17e0-41d2-ac4e-6c0a3f43a439', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', NULL, NULL, 4, '2026-01-01 11:17:41.850303', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('6864bc3e-53b9-4365-8671-11ac22006c01', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', NULL, NULL, 4, '2026-01-01 11:17:41.85885', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('1671dfeb-9351-429c-a554-334f91cd0219', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', NULL, NULL, 4, '2026-01-01 11:17:41.867576', 1, 'Sébastien BURCKHARDT', 'Transition du status vers → INJOIGNABLE : Échec de l''envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.'),
	('dfd4ef8e-5d2f-4c2f-aecf-baf6d2bf311a', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', NULL, NULL, 6, '2026-01-01 11:17:57.367211', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9058aae8-d368-45b2-ac2c-6721265ffb26', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', NULL, NULL, 6, '2026-01-01 11:17:57.59397', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('120c4750-b69e-453a-a4b5-7729ea942f9b', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, NULL, 6, '2026-01-01 11:17:58.671435', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9c08b862-b8c6-4355-994e-09c861431cd5', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', NULL, NULL, 6, '2026-01-01 11:18:04.556253', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('756644bd-3759-4ee4-b889-ce926b1704ba', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, '1993-09-04', 6, '2026-01-01 11:20:01.044362', 1, 'Baptiste Leclercq', 'Mise à jour des informations du contact'),
	('487f5d29-b5f4-472c-8ec7-173dc8335865', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', NULL, '1993-09-04', 2, '2026-01-01 11:20:01.045773', 1, 'Baptiste Leclercq', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('b997bcf0-48e2-4223-b435-ecb8fe8c7c3b', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', 'florian.riviere67@gmail.com', '1994-11-16', 6, '2026-01-01 11:43:21.305806', 1, 'Florian Riviere', 'Mise à jour des informations du contact'),
	('7d0c2052-e919-4722-9f28-7331fd6cfae3', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', 'florian.riviere67@gmail.com', '1994-11-16', 2, '2026-01-01 11:43:21.306884', 1, 'Florian Riviere', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('c4bc8644-fb2e-48f8-a2a4-9edb6e8abdd3', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', 'stevann38@gmail.com', '1983-12-23', 6, '2026-01-01 11:56:17.361584', 1, 'Stevann Jasek', 'Mise à jour des informations du contact'),
	('36f95a84-67de-45db-ab78-829368050216', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', 'stevann38@gmail.com', '1983-12-23', 2, '2026-01-01 11:56:17.362527', 1, 'Stevann Jasek', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('42e8607b-8bd5-45cf-a9ea-6e550aa10cba', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', NULL, NULL, 6, '2026-01-01 13:06:41.921776', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('ce169e43-69a1-4a9b-9184-09dec37c7b62', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', 'jules.ehrmann@gmail.com', '2005-06-04', 6, '2026-01-01 14:26:30.181904', 1, 'Jules Ehrmann', 'Mise à jour des informations du contact'),
	('1975eb21-f9c9-42ee-a885-f34b92509bb9', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', 'jules.ehrmann@gmail.com', '2005-06-04', 2, '2026-01-01 14:26:30.182982', 1, 'Jules Ehrmann', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('08de472b-c8d4-46bc-ba60-e974f5819075', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', 'jacob.thibaut@hotmail.fr', '1987-05-15', 4, '2026-01-02 16:50:46.244249', 1, 'Thibaut Jacob', 'Mise à jour des informations du contact'),
	('55901d4d-eb87-4652-9c95-363f2e0eba64', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', 'jacob.thibaut@hotmail.fr', '1987-05-15', 2, '2026-01-02 16:50:46.245383', 1, 'Thibaut Jacob', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('efacbcc6-cbe5-473b-be1c-4bc40e176e9a', '91af7307-0c46-4276-8349-de60962d0017', '+33649874965', NULL, NULL, 4, '2026-01-03 06:04:43.812505', 1, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('4a7e50af-8865-4a5c-8b61-fec754b20a20', '91af7307-0c46-4276-8349-de60962d0017', '+33649874965', NULL, NULL, 5, '2026-01-03 06:04:44.246564', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('e633b95e-af1a-4bb2-987b-ee46a9432892', '91af7307-0c46-4276-8349-de60962d0017', '+33649874965', NULL, NULL, 6, '2026-01-03 06:04:59.878284', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('0d2cd3fc-9097-4195-8059-3e1540ce4ed3', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', NULL, NULL, 2, '2026-01-03 10:09:19.598755', 1, 'Sébastien BURCKHARDT', 'Mise à jour des informations du contact'),
	('539bbf19-45af-4883-a0fe-94045802ed67', '8bc693cd-3537-4dcd-8717-39b24bf56086', '+33685218647', 'zilliox.raymond@wanadoo.fr', NULL, 0, '2026-01-03 12:36:30.256203', 0, 'Anonyme', 'Enregistrement initial'),
	('f5735a77-ff3c-47d5-9c4b-1b5db0052a62', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'jmeyer@alsalux.fr', NULL, 0, '2026-01-03 12:38:16.706227', 0, 'Anonyme', 'Enregistrement initial'),
	('e097c049-983a-43a4-858f-6a2c8fab376a', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'jmeyer@alsalux.fr', NULL, 5, '2026-01-03 12:38:32.6027', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f3bff1af-89a5-4122-ae53-2740bd77aa3d', '8bc693cd-3537-4dcd-8717-39b24bf56086', '+33685218647', 'zilliox.raymond@wanadoo.fr', NULL, 5, '2026-01-03 12:38:43.290523', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('0c6a54ab-8e32-4f2e-b024-31467fde54d0', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'jmeyer@alsalux.fr', NULL, 6, '2026-01-03 12:38:48.01899', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('300c48f9-0454-42d3-b388-796ddc71a07e', '8bc693cd-3537-4dcd-8717-39b24bf56086', '+33685218647', 'zilliox.raymond@wanadoo.fr', NULL, 6, '2026-01-03 12:38:57.950042', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('292a3407-e918-4100-b046-aa57c2d9c5ce', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', NULL, NULL, 0, '2026-01-03 12:54:43.972256', 0, 'Anonyme', 'Enregistrement initial'),
	('829ffbd2-f79f-4297-95ee-8d5b6deb0cd3', '8bc693cd-3537-4dcd-8717-39b24bf56086', '+33685218647', 'zilliox.raymond@wanadoo.fr', NULL, 2, '2026-01-03 14:30:07.058459', 1, 'ASHS BOT', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('7dcb571a-fd58-4884-8162-09e9e3a49698', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'jmeyer@alsalux.fr', '1979-01-31', 6, '2026-01-03 17:14:03.762796', 1, 'Jérome Meyer', 'Mise à jour des informations du contact'),
	('7f7d694c-a176-4176-b341-bca7f2347da0', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'jmeyer@alsalux.fr', '1979-01-31', 2, '2026-01-03 17:14:03.764424', 1, 'Jérome Meyer', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('120766de-1deb-4b1e-8b70-fc775160e27f', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', NULL, NULL, 5, '2026-01-03 18:37:56.526969', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('f7af972d-91f2-4ffe-a921-1fd64d58a682', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', NULL, NULL, 6, '2026-01-03 18:38:15.978972', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('555c3120-1185-4cbe-882e-5c5290e5c177', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', 'pressepuree74@wanadoo.fr', '1974-07-07', 6, '2026-01-04 10:15:33.280408', 1, 'Stephan  EHRMANN', 'Mise à jour des informations du contact'),
	('f7e4f633-d5bd-45e6-af98-2729b7682111', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', 'pressepuree74@wanadoo.fr', '1974-07-07', 2, '2026-01-04 10:15:33.282077', 1, 'Stephan  EHRMANN', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('937094a6-3cd5-4c29-8a55-fa433a03208c', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', 'floo.baehr@gmail.com', '1990-03-18', 2, '2026-01-04 16:04:05.903889', 1, 'Florian Baehr', 'Mise à jour des informations du contact'),
	('cbdc6301-61f3-4dfa-8618-00a7e10a8532', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', 'floo.baehr@gmail.com', '1990-03-18', 2, '2026-01-04 16:04:05.905013', 1, 'Florian Baehr', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('04b78bdf-df80-4512-9a2d-2cfa40e45099', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', NULL, NULL, 5, '2026-01-06 19:54:09.938143', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('406fb369-9fc9-4900-8e96-22dd66109256', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', NULL, NULL, 6, '2026-01-06 19:54:28.696006', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('8500b022-89b7-42c1-899a-196149527009', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', NULL, NULL, 0, '2026-01-06 20:04:44.371045', 0, 'Sébastien BURCKHARDT', 'Enregistrement initial'),
	('ea11eee0-86c5-4bcc-b020-eb7e870c145e', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', NULL, NULL, 5, '2026-01-06 20:04:44.754967', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('00a6e94e-2ce3-4cf7-bbdb-ce9792a55205', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', NULL, NULL, 6, '2026-01-06 20:05:01.830382', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('778b0205-8091-488b-999f-aaf3877469c9', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', 'jean.de-nicola@orange.fr', '1997-06-29', 6, '2026-01-06 20:06:07.647858', 1, 'Jean De Nicola', 'Mise à jour des informations du contact'),
	('6723fcfb-843c-4d5c-996b-1d34db2c64a5', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', 'jean.de-nicola@orange.fr', '1997-06-29', 2, '2026-01-06 20:06:07.648862', 1, 'Jean De Nicola', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('489f2bf9-c386-43f3-b8be-5814c9f3dcab', 'db1ecd95-b0bf-4581-99b0-955622143a74', '+33645079205', NULL, NULL, 0, '2026-01-06 21:14:55.04435', 0, 'Anonyme', 'Enregistrement initial'),
	('ed962017-315e-40de-bd6e-0436413f117f', 'db1ecd95-b0bf-4581-99b0-955622143a74', '+33645079205', NULL, NULL, 5, '2026-01-06 21:15:21.592221', 1, 'Sébastien BURCKHARDT', 'Mise à jour du status d''envoi du SMS. Transition du status vers → ENVOI EN COURS : SMS de validation a été envoyé mais non réceptionné'),
	('544c355b-9093-4a5a-9a69-1cdb2dd21f7f', 'db1ecd95-b0bf-4581-99b0-955622143a74', '+33645079205', NULL, NULL, 6, '2026-01-06 21:15:40.362313', 1, 'ASHS BOT', 'Mise à jour du status d''envoi du SMS. Transition du status du contact vers -> SMS REÇU'),
	('9afeff97-7d67-443d-9710-caaf8e148e2d', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', 'daulclement@gmail.com', '2000-10-19', 6, '2026-01-06 23:29:47.571814', 1, 'Clément  Daul', 'Mise à jour des informations du contact'),
	('febfc222-810f-4c47-8e43-7a7f012dbf77', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', 'daulclement@gmail.com', '2000-10-19', 2, '2026-01-06 23:29:47.572694', 1, 'Clément  Daul', 'Transition du status vers → VALIDÉ : le contact a validé ses informations'),
	('6ffc3882-6cac-48d2-a3fa-16178303616a', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', 'qqmunch@gmail.com', '1988-06-23', 4, '2026-01-07 07:12:49.234937', 1, 'Quentin Munch', 'Mise à jour des informations du contact'),
	('1df4721b-72d4-4f21-823f-6ac9fdb4ebe9', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', 'qqmunch@gmail.com', '1988-06-23', 2, '2026-01-07 07:12:49.236463', 1, 'Quentin Munch', 'Transition du status vers → VALIDÉ : le contact a validé ses informations');


--
-- TOC entry 3475 (class 0 OID 16434)
-- Dependencies: 228
-- Data for Name: former_teammate_history_entity_roles_at_time; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.former_teammate_history_entity_roles_at_time VALUES
	('98078a4a-0819-492d-8305-c29e7c5c0d86', 0),
	('11f5f1ff-dc05-4b24-8ab3-9120fb1fbb0d', 0),
	('3805f5ca-9f6f-4b52-babb-6c5279944eb2', 0),
	('000d0c0a-51fd-4af2-9f60-d2eb5e1c17af', 0),
	('7d4b43f3-5cf7-4640-9ff4-24023d97f02f', 0),
	('e3de8746-33c4-4ca2-bfa1-01759006e4f5', 0),
	('58306abf-8525-4ae4-9d92-87e2d98da974', 0),
	('fed72fa9-6d6b-4052-be97-f45029ebd7cf', 0),
	('ea3feb28-94b0-47b8-9fc3-fbe65cacfe0f', 0),
	('ea3feb28-94b0-47b8-9fc3-fbe65cacfe0f', 1),
	('08d69a0b-351e-491e-a47e-360cb27c219a', 0),
	('08d69a0b-351e-491e-a47e-360cb27c219a', 1),
	('85f8fb56-ca6b-4f4d-ab8f-366046dd1ed9', 0),
	('c0ce01c5-0820-4c63-957d-2cd53828ea78', 0),
	('d4bb3a45-f767-472a-ac7e-3866e906f112', 0),
	('3f09197b-3e31-441d-ae44-1d1131e53080', 0),
	('7de27678-e3b5-489b-9692-2d4f0d9590dd', 0),
	('91929503-6672-41c0-8062-76c4cb8132bc', 0),
	('b3c9d197-06ee-4b8b-80d8-1c8e3114e29e', 0),
	('b3c9d197-06ee-4b8b-80d8-1c8e3114e29e', 2),
	('169257ec-8486-4ffc-aeac-3a0273199e18', 0),
	('169257ec-8486-4ffc-aeac-3a0273199e18', 2),
	('1437ea38-1a24-4dac-9dea-391dadfc3d17', 0),
	('b4220be3-d912-463a-ae61-b1e5cc31cf45', 0),
	('c9aef022-3f96-4c67-bfa4-d9dc90bdd478', 0),
	('5cc17cb7-8268-451c-a054-c6cfa05d2770', 0),
	('1f1a7670-bcb2-4afa-8f0b-9ee2a22f7611', 0),
	('1f1a7670-bcb2-4afa-8f0b-9ee2a22f7611', 1),
	('7dae8e3f-c700-4a24-ab08-ed0d026114cc', 0),
	('7dae8e3f-c700-4a24-ab08-ed0d026114cc', 1),
	('a2aeda76-90f0-4587-b6eb-3d9d9f3a3472', 0),
	('765ece28-e6e9-4514-af0f-da0dd94dfe15', 0),
	('74288f34-5711-4811-8e0a-54588c4cf51e', 0),
	('be64da91-851c-4335-9e60-2f6702a95cbd', 0),
	('c5ea5de4-ed4a-4329-98fa-9984f56f3c83', 0),
	('c5ea5de4-ed4a-4329-98fa-9984f56f3c83', 1),
	('0138ea71-b806-460b-b8b8-76a10ee8ca5a', 0),
	('0138ea71-b806-460b-b8b8-76a10ee8ca5a', 1),
	('b1801592-c9db-447b-aae7-5f9fb81180af', 0),
	('fb6991dd-3e45-4733-b275-d5112fc83324', 0),
	('73486d73-e82f-49da-8526-db7fc3a2d202', 0),
	('73486d73-e82f-49da-8526-db7fc3a2d202', 3),
	('9f807dce-1003-4c2d-8bf9-54cf3f62b41e', 0),
	('9f807dce-1003-4c2d-8bf9-54cf3f62b41e', 3),
	('57925979-7fb3-4738-9c10-360a4750cf57', 0),
	('08e3c9c2-a0e3-4303-819c-7756de7eabb2', 0),
	('bf5b1dce-4124-4d0d-9cf1-412626647f0d', 0),
	('14fdf95d-f046-4aeb-a1f6-dad2a70f8638', 0),
	('d0b22b7d-002b-4013-b9dd-08ac05cd3925', 0),
	('1516810e-aee7-4c6c-bfbb-cf8843d40a41', 0),
	('02d0b1b0-2a5a-4c99-9ca8-ed45cada1898', 1),
	('2b898d4f-04a3-463c-8fef-a3a616323a12', 1),
	('c5963a67-400e-4820-9118-810d756c23df', 0),
	('71ec9a5a-6c04-4e43-8b96-fd5f4e7b5e3a', 0),
	('8fd617d0-6453-4c7d-be8c-d9546999eefc', 0),
	('36d2a4e7-01e0-444a-86f0-315ad5fff955', 0),
	('0676c126-1e74-405c-80a2-3a71e44a43f3', 0),
	('deef51ca-c6f6-4d61-9cf3-f96e97d5305b', 0),
	('8097d8a2-3ce2-4e73-a762-83c785f226d3', 0),
	('17936631-7319-4c22-84a3-0b5564a039c2', 0),
	('8e2cca21-40c2-47e7-9137-a5f292fb97bf', 0),
	('090db479-c2b6-4915-b96c-f11812d69152', 0),
	('0f798f88-2619-486d-a8ea-e2355e2212f3', 0),
	('ed8c849f-79c2-46ad-9d3b-026afdd03c80', 0),
	('f6327103-f435-4b6e-8005-9bb54f19e289', 0),
	('bbf38e48-938f-41be-a8b4-dfe6360096dc', 0),
	('93e5cbc8-9168-4f52-aabd-afd9e93625f7', 0),
	('6ff5aebc-ea7b-40c8-8028-6172623b847e', 0),
	('6ff5aebc-ea7b-40c8-8028-6172623b847e', 1),
	('d45e892b-3ded-40f7-b41b-7dade3a9fa44', 0),
	('d45e892b-3ded-40f7-b41b-7dade3a9fa44', 1),
	('1f629e85-c212-4c6b-9850-b29005e6226b', 0),
	('c9e3c052-53f1-421d-8bfa-cf452a9d43fa', 0),
	('50956828-08e6-4e37-89dc-085c208ed273', 0),
	('2a2f281f-30c9-440a-851d-a78a531c3405', 0),
	('1b0118c0-ccc2-4fda-b3f9-a77767aeb925', 0),
	('5d46c043-6c56-446c-ac0b-246a59aafe63', 0),
	('a1d393f1-31b8-4051-9864-6b82d6174f40', 0),
	('38e453de-7105-4a33-b0b8-648532ec1411', 0),
	('72fb76ca-8a86-41a1-abfe-0ab19029d875', 0),
	('a4df00d4-d5e8-4d4c-a0f4-acc6a59a69bc', 0),
	('1d552878-557f-4793-8693-792873afbe27', 0),
	('1d552878-557f-4793-8693-792873afbe27', 1),
	('298ac691-a56d-449d-9819-00cfd36f21ad', 0),
	('298ac691-a56d-449d-9819-00cfd36f21ad', 1),
	('d9983c6f-053a-4caf-ad45-2270802e09ac', 0),
	('88da12a2-7740-4066-9662-6d600609b6ef', 0),
	('96820ab9-0ae8-497b-a582-397e3d9b1bd0', 0),
	('295bee11-6b64-4cd5-b770-4dbf7f120edf', 0),
	('a68996ef-181e-4ee9-8e36-6a5a978934be', 0),
	('722f0215-c764-407b-b0e6-a44ab9dd0942', 0),
	('4e3c717b-4955-431b-98e1-05214233db51', 0),
	('2cb08acf-96de-436c-b1d6-d30231a77e45', 0),
	('9f76f95c-0605-49f7-a757-df584ae0bf94', 0),
	('ee1988b2-4a15-49c2-bd2d-8feb1aa65e65', 0),
	('ea0aba07-d77f-4db5-90cb-281d989b76ae', 0),
	('1182cc86-dcc5-42ba-9f1b-87bdd4c1b408', 0),
	('738c728d-3ab1-4843-94fd-c328fc877312', 0),
	('77488ce2-120e-445c-8f38-7767613ae883', 0),
	('9bcd2386-e6b2-46f2-aaf5-b92c1d4533b4', 0),
	('5e9878cc-bf01-45c4-be5d-b11b5c788b26', 0),
	('fa40b383-2b60-4186-8fce-cc9966f83f75', 0),
	('cdbf63e9-0450-4250-b3e6-aa1845786242', 0),
	('c4b338d6-9458-41a6-9de3-5337f17e449b', 0),
	('1b66e903-11cc-4ea2-98f5-331fdde2fc3e', 0),
	('1b66e903-11cc-4ea2-98f5-331fdde2fc3e', 1),
	('7cc67e3c-a66c-4e71-8f5a-7fb5bcd0da13', 0),
	('7cc67e3c-a66c-4e71-8f5a-7fb5bcd0da13', 1),
	('489d4f7a-588a-4906-a113-6f76a6a8da5d', 0),
	('caac6ba4-6045-4d1c-8252-0b0c101ec506', 0),
	('0f732e8b-4034-4db0-9ef1-386ff888dac9', 1),
	('acea0484-bfb4-4945-85ea-55d8bd03a124', 1),
	('a706af1e-d47a-40a6-8eab-96dd7adfa69b', 1),
	('a706af1e-d47a-40a6-8eab-96dd7adfa69b', 0),
	('ee41a169-5ef6-4514-8759-9f259b1c1ead', 0),
	('725af7c9-5ca3-4d32-b182-ab9136de42e0', 0),
	('ee8e1c39-19c6-4295-b703-d02abc6705af', 1),
	('ee8e1c39-19c6-4295-b703-d02abc6705af', 0),
	('ca9ab7d7-7e07-472b-b07a-3e26ffcd4c47', 1),
	('ca9ab7d7-7e07-472b-b07a-3e26ffcd4c47', 0),
	('596cd4f9-d7ad-49f3-8748-03ab61419208', 1),
	('a0816283-5dd3-4c61-af87-0bde9df99a98', 1),
	('1646b68a-934e-41e3-a988-b8c4105fbba7', 0),
	('141cafcc-fa5e-402b-9164-7293b25b1788', 0),
	('f620de66-5ccf-406d-8292-d28f496c7b4a', 0),
	('0443422e-9c4e-4abb-a0f7-51c74baf1663', 0),
	('21545344-54a0-45c8-8881-b81e8e4dcac5', 0),
	('cb6568a3-6e4f-45aa-9284-5919ecb2587f', 0),
	('6bf98db7-bc49-4600-87ac-8f5c0cc35d46', 0),
	('0498cd85-928d-4967-88de-9db72a291107', 0),
	('07686c23-537a-48ab-9480-dd336f76db10', 0),
	('f9eecbd5-bdc8-40da-86fc-511cf3eb0c0c', 0),
	('97a14aac-f423-4f50-80fe-04f29a8ea644', 0),
	('5b6abb35-7599-44f0-88f2-80f36708c42b', 0),
	('53fb3669-c1ea-47b3-b336-184869844b6c', 0),
	('45e23589-237d-4fb2-a56a-e7a0d530e007', 0),
	('91f0fc1c-5bdf-4c87-8b0c-fed2ca94b1a4', 0),
	('5840c91b-bb3d-4f80-b445-5354bc1b7e3a', 0),
	('6811ad37-7518-4b0d-910f-a1166fcae783', 0),
	('58103b80-dbee-46b8-aeec-7aefc5e4a11a', 0),
	('8ac0b793-b4f7-4161-9338-88b727228b81', 0),
	('d8087e6a-71e1-4433-a8a7-3972ad5ccf72', 0),
	('c15a9ab3-dac1-462e-bfa9-7b6e491a83af', 0),
	('415eee17-f992-4037-9f31-d434e676b9ce', 0),
	('4d1bf83e-5d10-4119-afbb-f1fec242e4d8', 0),
	('b9a92094-3bb1-44c5-8680-32a6b5d1122e', 0),
	('77be819f-1092-4a8c-b6ce-00e21135972b', 0),
	('08c3f093-5d73-4423-ba37-f95a2cd0ea86', 0),
	('efaf2ebc-7be7-43fa-bf9e-a9e7997b8c34', 0),
	('9ef5fab2-86b4-423c-98d5-efe686f24aa9', 0),
	('707778e6-1c41-4a42-a84d-faed3063ee21', 0),
	('7fc92567-f58e-4d91-b35c-4d04b936faed', 0),
	('e4a83bb5-23a1-4777-a394-3c5db07a884b', 0),
	('c17af034-da31-4289-87da-0f68166892c8', 0),
	('ff67e42e-bf2f-4b2b-960f-32ccefdc35f4', 0),
	('19806961-23c0-4bcf-b6f2-8c4aea4294a8', 0),
	('6f9b38bf-361e-47e9-996a-f3d8c2de1472', 0),
	('9c16c0f7-f2f4-410e-bc8b-346a0c02ab85', 0),
	('9c16c0f7-f2f4-410e-bc8b-346a0c02ab85', 1),
	('974a5d25-ba3a-4c4e-820d-4597dc1b4e29', 0),
	('974a5d25-ba3a-4c4e-820d-4597dc1b4e29', 1),
	('979e2b9b-0c63-4a65-b8ea-f16dda20ef22', 0),
	('e5b8c62a-4fd2-42fb-9268-e1265668b989', 0),
	('e5b8c62a-4fd2-42fb-9268-e1265668b989', 1),
	('768b76dc-2100-403b-bd09-d46452ce20ba', 0),
	('768b76dc-2100-403b-bd09-d46452ce20ba', 1),
	('ff5708af-20b9-4b36-8b0b-ae9cb7cdf0a9', 0),
	('f8b60f35-2a38-4b38-9e33-6270b9ff013f', 0),
	('f8b60f35-2a38-4b38-9e33-6270b9ff013f', 1),
	('7c3d5a39-6378-4a89-ab95-21598ec29d5f', 0),
	('fcc28bf9-89c9-4980-9558-952a899d868b', 0),
	('bfbae56c-e289-4f1a-97e1-7123f50c55db', 0),
	('04977c61-234f-42dc-a573-665325cfd3a1', 1),
	('1688a2d3-3875-4846-9941-18182a61193f', 0),
	('c48689c9-d5e5-4919-8b1b-90613e9ba6af', 0),
	('33d3e213-afa9-4b65-b517-bc31c657c5dc', 0),
	('d277aca5-8c5b-4e4b-8dee-be5a69fe7778', 0),
	('400d814f-02a7-4414-b3d7-1ca92bc0152a', 0),
	('6ec867f1-9dd8-4562-8e62-be652843a169', 0),
	('4d1e2d4b-0ddf-4489-a0fd-0493b823f8b3', 0),
	('fbc67b0f-5b73-4b54-bab5-580262502c0f', 0),
	('90d14138-4e72-48d7-91f6-3a61df10fa6c', 0),
	('906f6aba-b63e-4a01-bc1d-854d715118e7', 0),
	('ee9f0c04-749c-477c-a23b-37f7c61fa6f4', 0),
	('ee9f0c04-749c-477c-a23b-37f7c61fa6f4', 1),
	('94a343ae-a481-40dc-a1ec-37bbf7b2b5a7', 0),
	('94a343ae-a481-40dc-a1ec-37bbf7b2b5a7', 1),
	('d62c2e4f-ddd5-4b5f-b352-06ec76bc0f79', 0),
	('190795f2-77da-4251-a797-79afcacae1f6', 0),
	('dae7b67f-8e50-4f1b-b220-0566cb127c87', 0),
	('a93451bd-7ef3-4ff5-8ef2-adfebe623e22', 0),
	('4c79eb9c-ccf2-49d1-af58-d4a0fb7405d3', 1),
	('4c79eb9c-ccf2-49d1-af58-d4a0fb7405d3', 0),
	('3b135b60-69df-48af-9eb9-4c03cd4015f2', 1),
	('3b135b60-69df-48af-9eb9-4c03cd4015f2', 0),
	('faef312d-9aa9-4c9d-bcd2-1352209d2d9c', 0),
	('2997b685-9f54-4e9c-ab7d-2696e0ee8269', 0),
	('b31db9b9-078b-48d1-821c-a1c0b1b68701', 0),
	('6895dfde-7682-4a7d-be16-1bf27b8b5baf', 0),
	('c34d4176-3275-4b47-8aaa-60104f840810', 1),
	('b98ca541-de42-4994-b261-5df85ec6bb88', 1),
	('8a7eb78b-7f7c-48bf-a524-8a840c8576da', 0),
	('2bcfa21c-1667-477d-acd0-daa2e6e94b7d', 0),
	('221ddedb-e0e9-4bab-8bce-23bb3780de99', 0),
	('9fae7724-17fc-4a7a-bde1-fccfc519310a', 0),
	('aa20719d-0298-4192-84f1-0f95a9a465fc', 0),
	('e2e13a16-091f-4ad8-ba51-d6ad083ec3b9', 0),
	('274790bd-3969-4325-8f9f-ae3d485dcd01', 0),
	('274790bd-3969-4325-8f9f-ae3d485dcd01', 1),
	('76f889b4-03e1-42ac-89a4-2683ae528489', 0),
	('76f889b4-03e1-42ac-89a4-2683ae528489', 1),
	('46b87862-7f3b-4ea5-a42c-45a0dfc2e50f', 0),
	('60f6d24e-8d17-4970-93b3-f003a661ba91', 0),
	('739f6fc3-a326-48dd-a1eb-29123e568986', 0),
	('371779b8-26be-4667-bf81-337e12c73a18', 0),
	('d1f9fa62-c132-4f7e-85d4-a8ac4ea91da9', 0),
	('d23d3c92-fa24-461e-87be-755ea5c48723', 0),
	('02f40de1-ea70-4c38-ac70-c360569cf72b', 0),
	('80ff59dd-9bc4-42d7-94dd-2ad4bddd50b4', 0),
	('2f6f8a64-124c-4531-804d-e689fe1f3274', 0),
	('e699a4ef-09e4-4f40-b548-039d1b252917', 0),
	('fd9617bf-0ce0-4499-8283-54fac1e889a4', 0),
	('fd9617bf-0ce0-4499-8283-54fac1e889a4', 1),
	('f24927b1-c1af-4e3e-9d7d-bede0c28132e', 0),
	('f24927b1-c1af-4e3e-9d7d-bede0c28132e', 1),
	('84fab2d3-d04e-4c70-9166-c537740d1748', 0),
	('d499f03c-476c-4f3e-9d9b-d712c06fb6bf', 0),
	('aa9d2179-89bd-44e5-9a13-afb4df167983', 0),
	('9a6028d3-d805-4161-b406-f48356a54dcc', 0),
	('d60f9f31-f75e-4a10-9be2-83192933c71b', 0),
	('a8590272-d9e4-4fa0-bc41-238c863c97ba', 0),
	('dc52ff2f-530b-4df9-a138-d7ec23ac4d79', 0),
	('cab732e3-142d-40d0-8125-c6e1cffcf16d', 0),
	('179ecc8c-fb9a-40f1-91d0-4b28b89f5211', 0),
	('2023116e-30d0-49b8-ae61-3a5b7d660c22', 0),
	('3ecfe661-4df0-49f4-877e-8cf438af00e1', 0),
	('1655c45c-704e-4c26-842c-8bb65e13b4f9', 0),
	('3df486e3-a734-4326-a807-3aca6031729f', 0),
	('7b6dce18-0feb-458f-9cb1-f4ab10110949', 0),
	('fc1116a2-58f7-4095-9498-aa18bafed317', 0),
	('8b9aef37-1004-4b66-9191-0fa24b9e8e19', 0),
	('98fe5950-68b3-4cd2-a40a-b494a7f8f2b8', 0),
	('0ff737da-4c39-4867-83cd-d61169e80ebc', 0),
	('96e1bd68-4f8b-49eb-a8fe-80ce6600a692', 0),
	('333ae246-77f0-4702-ad3a-2df0f31898de', 0),
	('14df8b90-9557-49cd-8bd4-1afba935a6d7', 0),
	('fe900b8c-1652-4cf9-888a-4fbe2d85c900', 3),
	('834f325a-3a7f-4e01-966c-ef3896bb267d', 3),
	('b8f580b1-6fe3-4910-943b-9c627df25e66', 0),
	('58c5601e-8b68-4ed0-8d8f-0c627be406b7', 0),
	('0a189b06-f513-4396-b42d-4c767deb0abb', 0),
	('140cc452-6ac0-473b-9f7a-fada067e0a85', 0),
	('51d0422a-9670-46ba-897d-2f5c9e7bf76f', 0),
	('4ce62e15-5eea-4ff4-b8b8-511b591dd64f', 0),
	('66407f7e-9183-4abf-a347-95bf884989cc', 0),
	('21f1c6d2-fa6b-4ddb-a620-74fc6ac7ebd2', 0),
	('6b635c53-d13f-4a54-84ec-a1e5d4a0d285', 2),
	('df50330f-b8cb-46f6-91c7-f55a00f9addb', 2),
	('56b5b4f5-dd28-41e3-86e1-618064359ed1', 1),
	('56b5b4f5-dd28-41e3-86e1-618064359ed1', 0),
	('dfd4ef8e-5d2f-4c2f-aecf-baf6d2bf311a', 1),
	('dfd4ef8e-5d2f-4c2f-aecf-baf6d2bf311a', 0),
	('756644bd-3759-4ee4-b889-ce926b1704ba', 0),
	('487f5d29-b5f4-472c-8ec7-173dc8335865', 0),
	('b997bcf0-48e2-4223-b435-ecb8fe8c7c3b', 0),
	('7d0c2052-e919-4722-9f28-7331fd6cfae3', 0),
	('c4bc8644-fb2e-48f8-a2a4-9edb6e8abdd3', 1),
	('c4bc8644-fb2e-48f8-a2a4-9edb6e8abdd3', 0),
	('36f95a84-67de-45db-ab78-829368050216', 1),
	('36f95a84-67de-45db-ab78-829368050216', 0),
	('ce169e43-69a1-4a9b-9184-09dec37c7b62', 0),
	('1975eb21-f9c9-42ee-a885-f34b92509bb9', 0),
	('08de472b-c8d4-46bc-ba60-e974f5819075', 0),
	('55901d4d-eb87-4652-9c95-363f2e0eba64', 0),
	('efacbcc6-cbe5-473b-be1c-4bc40e176e9a', 0),
	('4a7e50af-8865-4a5c-8b61-fec754b20a20', 0),
	('e633b95e-af1a-4bb2-987b-ee46a9432892', 0),
	('0d2cd3fc-9097-4195-8059-3e1540ce4ed3', 1),
	('539bbf19-45af-4883-a0fe-94045802ed67', 1),
	('f5735a77-ff3c-47d5-9c4b-1b5db0052a62', 1),
	('e097c049-983a-43a4-858f-6a2c8fab376a', 1),
	('f3bff1af-89a5-4122-ae53-2740bd77aa3d', 1),
	('0c6a54ab-8e32-4f2e-b024-31467fde54d0', 1),
	('300c48f9-0454-42d3-b388-796ddc71a07e', 1),
	('292a3407-e918-4100-b046-aa57c2d9c5ce', 0),
	('829ffbd2-f79f-4297-95ee-8d5b6deb0cd3', 1),
	('7dcb571a-fd58-4884-8162-09e9e3a49698', 1),
	('7f7d694c-a176-4176-b341-bca7f2347da0', 1),
	('120766de-1deb-4b1e-8b70-fc775160e27f', 0),
	('f7af972d-91f2-4ffe-a921-1fd64d58a682', 0),
	('555c3120-1185-4cbe-882e-5c5290e5c177', 0),
	('555c3120-1185-4cbe-882e-5c5290e5c177', 1),
	('f7e4f633-d5bd-45e6-af98-2729b7682111', 0),
	('f7e4f633-d5bd-45e6-af98-2729b7682111', 1),
	('937094a6-3cd5-4c29-8a55-fa433a03208c', 0),
	('cbdc6301-61f3-4dfa-8618-00a7e10a8532', 0),
	('1859499a-e5d4-4ada-a36a-44225ff9ebb3', 0),
	('04b78bdf-df80-4512-9a2d-2cfa40e45099', 0),
	('406fb369-9fc9-4900-8e96-22dd66109256', 0),
	('8500b022-89b7-42c1-899a-196149527009', 0),
	('ea11eee0-86c5-4bcc-b020-eb7e870c145e', 0),
	('00a6e94e-2ce3-4cf7-bbdb-ce9792a55205', 0),
	('778b0205-8091-488b-999f-aaf3877469c9', 0),
	('778b0205-8091-488b-999f-aaf3877469c9', 1),
	('6723fcfb-843c-4d5c-996b-1d34db2c64a5', 0),
	('6723fcfb-843c-4d5c-996b-1d34db2c64a5', 1),
	('489f2bf9-c386-43f3-b8be-5814c9f3dcab', 0),
	('ed962017-315e-40de-bd6e-0436413f117f', 0),
	('544c355b-9093-4a5a-9a69-1cdb2dd21f7f', 0),
	('9afeff97-7d67-443d-9710-caaf8e148e2d', 0),
	('febfc222-810f-4c47-8e43-7a7f012dbf77', 0),
	('6ffc3882-6cac-48d2-a3fa-16178303616a', 0),
	('1df4721b-72d4-4f21-823f-6ac9fdb4ebe9', 0);


--
-- TOC entry 3477 (class 0 OID 16465)
-- Dependencies: 230
-- Data for Name: participant; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.participant VALUES
	(2, 'ashshand.philippe@orange.fr', '', '3c1336ed-0ddf-47b5-8de1-b22c52dfcd7e', 'Philippe', 'Thomas', false),
	(3, 'vott1984@gmail.com', '', '3fdd5f99-ed55-4368-a001-5d13328169b6', 'Vincent ', 'Ott', false),
	(4, 'florentaymeric@yahoo.com', '', '1ff9a603-d727-449b-84be-296933a48e94', 'Aymeric', 'FLORENT ', false),
	(52, 'gillesfiege@gmail.com', '', '3261c027-515e-4749-afd2-e29dc47e3591', 'Gilles ', 'Fiege ', false),
	(53, 'thierry.debargue@gmail.com', '', '58b14f0b-f1fe-4f44-915f-08178852697e', 'Thierry ', 'debargue', false),
	(54, 'audrey.thomas67@icloud.com', '', 'ee0db7e3-b441-42fd-a913-b421d07f9c84', 'Audrey', 'Thomas', false),
	(55, 'tcolnot2@gmail.com', '', '53875499-4002-48d7-90a2-dce0f4790b07', 'Thierry', 'Colnot', false),
	(56, 'marcky.raharison@gmail.com', '', '8e148459-fe3b-4202-9bc4-22d018c81c4c', 'Marcky', 'Raharison', false),
	(57, 'oliviak68@hotmail.com', '', '30297fb5-a7fe-4c9d-ae06-3f3ebaa42bdf', 'olivia', 'caron', false),
	(58, 'peggy.santos@hotmail.fr', '', '5877bdb2-73a7-4f96-97db-6b582d6ad91e', 'peggy', 'dos santos', false),
	(59, 'john-twelve@hotmail.fr', '', '808599bf-be4a-4eb1-915e-e32b23539142', 'John', 'WILLAUME', false),
	(60, 'kris.80@hotmail.fr', '', '850bd015-cd66-4819-aa64-e77ab964c6b5', 'Kris', 'Willaume', false),
	(102, 'gui13gui13@hotmail.com', '', '82e28815-c4d0-4f16-9956-926c1933fc3e', 'Guillaume', 'Reich', false),
	(152, 'berzug@yahoo.fr', 'Nous viendrions à 2, donc pour 50€ stp!', 'd5e9b7ee-f1de-4861-8035-8a219ac61673', 'Bertrand', 'Zugmeyer', false),
	(153, 'amelietrusch@gmail.com', '', '7f5c0a8c-cc9d-4aee-922b-6e7b4f20f122', 'Amélie', 'TRUSCH', false),
	(154, 'eric.chautant@yahoo.fr', '', '07289510-fc22-4aea-818e-53ddddf7beae', 'Éric ', 'Chautant ', false),
	(155, 'nelaespa@gmail.com', '', '133ac679-7eed-4b4d-a1af-bbda44df0115', 'Nelida ', 'Garcia ', false),
	(156, 'gr_pck67@orange.fr', '', 'c8daf5b4-e7ab-4924-adea-51bce899d44b', 'marie', 'Reich', false),
	(202, 'franck.sturm1@gmail.com', '', 'a90b5e1b-21be-4b34-9bfd-f0652ed47488', 'franck', 'sturm', false),
	(203, 'karlipierrealban@hotmail.fr', '', 'd07f9cb5-b366-437d-8645-5cde1a6b1947', 'pierre alban', 'karli', false),
	(204, 'laurelinelhotellier@hotmail.fr', '', '97835508-db5d-4f4d-8e6b-8812055cd822', 'Lauréline ', 'L’hotellier', false),
	(252, 'celine.bognitscheff@gmail.com', '', '3d2533dd-7373-45f1-bcb6-c198f38265d7', 'Celine', 'Toupet', false),
	(253, 'lienhartyannick@hotmail.fr', '', 'a284548b-447e-40c7-bba0-ed6d1f065f29', 'Yannick', 'Lienhart', false),
	(254, 'chelmi@evc.net', '', 'e100142d-9180-42be-a450-1d81074f50c1', 'Chelmi', 'Mutschler', false),
	(255, 'celia.schub@gmail.com', '', 'f3c2fb1a-0d92-4eda-9a2b-641ac84720b5', 'celia', 'schub', false),
	(256, 'sebastien.burckhardt@gmail.com', '', 'ef2da2d1-2815-486b-8841-96e3be9daabd', 'Sébastien', 'BURCKHARDT', false),
	(257, 'michael.hauler@gmail.com', '', 'aa92297a-f2bd-4b62-9ae0-8b23bd6cf3b3', 'Michael', 'Hauler', false),
	(302, 'cedricott@msn.com', '', '1e48472c-1afd-4917-b89b-09ab8e1720ee', 'Cedric', 'Ott', false),
	(352, 'mumukiki67@gmail.com', 'Je serai présente pour le repas et non pour jouer car je bosse. ', 'b1a703e6-d3de-4dc3-b3f0-8bdf64585b2a', 'Murielle', 'Kircher', false),
	(402, 'isabelle.karjouck@icloud.com', '', '12dc4697-5b0d-46f2-bd5d-3e2764dee8ac', 'Isabelle', 'Karjouck', false),
	(1000, 'af.andres.fabrice@gmail.com', 'Je serai donc présent accompagné. Nous serons donc deux.', 'd8962801-8690-4e7d-abe7-2b0e023268a7', 'Fabrice', 'Andres', false),
	(452, 'fantine.charbo@gmail.com', '', '843d3bb8-d1aa-41fb-9b69-46a8fdd04fce', 'Fantine', 'Charbonniere', false),
	(453, 'flavie.mehn4@gmail.com', '', '15df4994-3cdc-4ec4-a865-3c739711ab26', 'Flavie ', 'Mehn', false),
	(454, 'arthur.brugnano@free.fr', '', 'd5cb8cb0-46de-4311-a78a-ba4a4bb7cd96', 'Arthur ', 'Brugnano', false),
	(455, 'mathwbu@gmail.com', '', 'd3ac6803-0d88-4f9e-aabc-523de6a94ad7', 'Mathieu', 'Weibel', false),
	(456, 'moha.sahli@hotmail.fr', '', '4fc20240-a790-4cf0-9153-463fa4358591', 'Momo', 'Sahli', true),
	(457, 'c3lin0u@hotmail.fr', '', '6457c52d-ac03-40ec-9f62-a1fb516bdc1a', 'Céline', 'Noel', false),
	(458, 'mars25067@gmail.com', '', '320200a5-9c1c-497a-8542-32d875722e3c', 'Martial ', 'Aymonin ', false),
	(459, 'contact@nakara-sport.com', '', '698824fd-e633-4f48-9af4-198b473e2659', 'Sébastien', 'Narducci', false),
	(460, 'moraida.joffrey@hotmail.fr', '', 'ed14a168-c095-47d8-8ff2-34fd835d7486', 'Joffrey', 'Moraida', false),
	(502, 'jules.ehrmann@gmail.com', '', 'd91199cb-bf6e-437e-a129-56675beaece6', 'Jules', 'Ehrmann', false),
	(503, 'lucaswagner962@gmail.com', '', 'dcd5b8e4-4590-414a-a72d-d35e238781e6', 'Lucas ', 'wagner', false),
	(552, 'amielmj@yahoo.fr', '', 'ffb3c946-9342-420a-b2e8-6dc8534d7526', 'MICHEL', 'AMIEL', false),
	(553, 'florian.riviere67@gmail.com', '', '478626bc-af6d-4af6-afe8-69c3c3d904c6', 'Florian', 'Riviere', false),
	(554, 'remiwatrin@gmail.com', '', '6037f3ec-1abd-4fbb-83d0-6d70a8b44417', 'Remi', 'Watrin', false),
	(555, 'floo.baehr@gmail.com', '', '5ae17957-44a7-447f-8398-0c06fb46ef79', 'Florian', 'Baehr', false),
	(556, 'michel.schneeberger@orange.fr', '', '1349f8fc-21ab-4b8c-b904-34ebf9b37fda', 'Michel ', 'Schneeberger ', false),
	(557, 'camaradamba@gmail.com', '', '3fbce212-9b6f-4aca-8d91-18fc049cda74', 'damba', 'camara', false),
	(558, 'borjasimon@yahoo.fr', '', '488a8104-8a0c-4b5f-bd74-a8ecdd516347', 'simon', 'borja', false),
	(559, 'my.tu1988@outlook.fr', '', 'd8e34a82-eb4a-4d1e-8cbc-51810ee04a77', 'My-Duyen', 'TU', false);


--
-- TOC entry 3473 (class 0 OID 16413)
-- Dependencies: 226
-- Data for Name: sms_history; Type: TABLE DATA; Schema: public; Owner: app_prod_user
--

INSERT INTO public.sms_history VALUES
	('c343c919-76bd-4ad5-b2a9-08a0cf6d5b03', 'f468aa64-a23c-4aab-a66b-c21eaeddb403', '+33602035797', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ANDBNJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:07', '2025-12-06 06:06:59.154672', 'SMb91156d56b5aa2b4e89d2ac0ca7633a1', NULL),
	('0912a403-04fe-4af0-bcd8-d6ed144a4d9d', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RVRVEZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-06 03:18:08', '2025-12-09 03:18:18.010687', 'SM14ef50e0a232dbcb204930a130d71185', 'Erreur de type 30008 : null'),
	('bc865069-9e67-400c-925d-6401a9bdf7db', 'cd97f0bf-6845-4b2e-8af4-c1a239519783', '+33615730409', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UQOUPA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:20', '2025-12-06 03:46:32.124614', 'SMb85cf88fca6ebbf2e53cce97cb6c0464', NULL),
	('33beed2e-160c-436a-8de5-1b663188f1ac', '4cb7e91a-76fe-4e10-aa1e-e1a4d3a8c3ce', '+33684190357', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/TEBDDH
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:10', '2025-12-06 08:04:32.288787', 'SM90c89e7e8f233db6ca3bf9369f42d3c1', NULL),
	('953b020a-bddb-4011-b45e-acc48547128f', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/BGZUUX
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:21', '2025-12-08 05:57:13.405904', 'SMc0d96c53fc86d1cd365062c092c5b728', NULL),
	('dc385805-212a-45fc-862a-0d555b68c574', 'fef02115-d090-4a47-92af-bc51cc7b0557', '+33642931441', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PJHIEF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:11', '2025-12-06 03:18:20.938827', 'SMe86c3928107cfe0a1d92b0a9f5b9cd57', NULL),
	('c9406c47-b103-4e8c-b323-fb0110f5dfc0', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MRQWRJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:10', '2025-12-06 03:18:20.562092', 'SM68f03e07b504578008da86d74a3784df', NULL),
	('21a09f9a-6845-4609-b553-02d50916113b', 'ba093cf9-93bd-4dca-ada6-d58fa4b56089', '+33664852133', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CEAOPT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:13', '2025-12-06 03:18:21.871676', 'SMccb7260ad79069e5981898e5f829ec81', NULL),
	('57fca337-e68f-4284-84f4-4411f031ccb9', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XBOSOQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:12', '2025-12-06 03:18:22.792825', 'SM34bcc40c5f9081bfdb98fc34dae8f244', NULL),
	('68fe4e07-e48a-405b-94bf-1653b99d7a70', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CKSTQR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:11', '2025-12-06 03:18:22.057498', 'SM15367fe94c416aa55827de2c8c858985', NULL),
	('8edf3c4e-9d5c-44f3-82cb-5633d3ad6139', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/AVYHQD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:12', '2025-12-06 03:18:23.297769', 'SM3d520f2c582514c8c884c10fef4485aa', NULL),
	('6b810ae5-fd74-4347-88f6-3bbd37414322', '0cd6f3ff-3bd3-4264-8093-ef0d19accddb', '+33638760440', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/VFXXJJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:09', '2025-12-06 03:18:24.900587', 'SMf0ed449a12b883c1fb42c4f89c40aba5', NULL),
	('4acc9938-9349-49be-a139-99a32ad29f18', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KFKSEU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:09', '2025-12-06 03:18:20.088993', 'SM848734cd95fbbe377ae0851a8f07f6e3', NULL),
	('ce202c54-2019-4dbd-9f4b-187e1669a12a', '319de8c0-be99-4210-9ecc-ba43c0c7e382', '+33607827250', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XLAXUD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:22', '2025-12-06 03:46:30.934539', 'SM81c66cb04ef4cf7f8f8a10d7c2ab3056', NULL),
	('e8fb5f41-28a2-444f-a54a-62100759a253', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/SRMBHN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:13', '2025-12-06 03:18:25.359791', 'SM71adafeda4e75677d0c26a604d8e7dcd', NULL),
	('6f44d0d8-8839-428b-8417-67923b2b3798', 'd713af8b-da0d-432f-8ff3-747605cd040f', '+33673186830', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/IMSDMG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:14', '2025-12-06 03:18:25.9745', 'SM0d8efffd46da4edab535688d19454700', NULL),
	('dd883771-ff5a-4ee1-8f10-1a5869bf442e', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZBYMEL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:14', '2025-12-06 03:18:24.32464', 'SMc4a28d9fa9cc948f60313f3448377c8e', NULL),
	('dd961d5c-454b-478f-afcf-5655726c5bb7', 'd0c975f7-14b4-496e-b2f4-e18afacab64d', '+33612572685', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZMZAZL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:15', '2025-12-06 03:18:26.373039', 'SM107884e9896245569ef1e5ab3dd50b3a', NULL),
	('24b104fc-dfc0-4c82-859a-6e10e38489d1', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZYQXSA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:17', '2025-12-06 03:18:27.000052', 'SMc26b0fd78dbbeef8d91f8e012a130f49', NULL),
	('f867716a-1cc4-4f90-b1a1-086716691367', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UALFFU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:19', '2025-12-06 03:18:31.160704', 'SM8129a53919f109f4681cef760844a235', NULL),
	('4d1ca1c0-20f2-45cb-8e14-7af1fcb66cab', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HYUATR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:16', '2025-12-06 03:18:28.442476', 'SM503a7bffc0e0b352d7a9cf40f8f86030', NULL),
	('f9d0ffab-522c-4f62-ab56-c78b302a4765', '10040925-2d1d-461a-9f0b-9eefc08e625c', '+33671827337', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KMUIBK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:14', '2025-12-06 09:00:29.30032', 'SMc5b75205653eda98ae85db339acb08ad', NULL),
	('08588514-cbe1-4b31-9638-a015214c7bd3', '4398bcec-fb29-41c3-8088-f8ca66120f21', '+33615354743', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/VNHQGC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:18', '2025-12-06 03:18:28.44453', 'SM25ca83718710176d066b3a1ad30ae975', NULL),
	('445a76da-be31-4d9e-913c-d9e920f15f03', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/EJLAIF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:18', '2025-12-06 03:18:29.869026', 'SM8fcdb39351af2e92bde0f3af3ba7e7b6', NULL),
	('4a8537a9-259e-418b-a998-2910a6d3eb08', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ELHDPY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:16', '2025-12-06 07:59:21.7887', 'SMb9fdf22c97bffb0158357915cc47fd2e', NULL),
	('b3795e5c-ecc5-4b52-82a3-f49388682408', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZQFWHQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:17', '2025-12-06 03:18:30.175211', 'SM276cd0292c3f03452de0a916b73c9e47', NULL),
	('098b5e0c-0544-4677-9d8c-7febe894cd51', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/LUURPL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:15', '2025-12-06 03:18:24.106007', 'SM6890d46b17db2f0ebd05f7921a6a7b8f', NULL),
	('9b546be4-7517-4d13-8a4f-1885c302c799', '87526c43-8507-450c-b315-f2b6ed5d4833', '+33619739111', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KHWTSQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:18', '2025-12-06 06:16:03.345746', 'SM1b2643543ea0f12027c5d98e34a3b912', NULL),
	('5be94390-45ae-405a-97ce-3e1d484324df', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RKPRCJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:19', '2025-12-06 03:18:29.870862', 'SMcb17ca9e99acb37825e19a3c886d27ee', NULL),
	('4f85e87c-7117-4bcf-83b9-2eb8d0a2f5d0', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MNYYLJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:20', '2025-12-06 03:18:29.761886', 'SM349df57577a60add6ed4272445665848', NULL),
	('8237e227-f77c-4b40-b0e6-59ea95cb3002', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DNFRFO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:22', '2025-12-06 03:18:33.320133', 'SM35b0767d4a276a51de063f1461eebb1b', NULL),
	('d9280bac-0473-4d79-a278-a10b77bd9727', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/YCXMMI
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:22', '2025-12-06 03:18:33.896821', 'SMe1551c9a2094004c08364bb1d7239bbd', NULL),
	('4083abd8-f1ee-47c3-beff-73d69c6c257a', 'ca6789af-a398-4263-919b-026439df484b', '+33687675235', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DMVFTY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:25', '2025-12-06 07:55:35.738371', 'SMec52e98803e0c463de44fdb00edae78e', NULL),
	('3cc4c1e6-37a7-4fcb-a782-8b56b723e73a', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/NWAZTK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:24', '2025-12-06 03:18:34.158898', 'SM4c4f0d5441101c1d3e0bcebd2a4a348b', NULL),
	('a1929bef-625d-4594-8f83-af606567ba7b', 'b63e0a87-088b-4a54-8ce9-619b09ecaf74', '+33685504977', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DCUKKP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:23', '2025-12-06 03:18:35.089182', 'SMdc9e18ea10a71c917978a3d72723d3ae', NULL),
	('748bdcaa-b489-4363-a1ae-5a17086877ec', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HYISTJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:23', '2025-12-06 07:16:12.588449', 'SMbaa0cfb1b6c268a0909518f5efa8e6b2', NULL),
	('d050666a-a5d7-412e-8df4-83e7454659fd', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/FCCWTW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:24', '2025-12-06 03:18:35.653376', 'SM50c4e6a4bfded2c8c849eea56cb53af7', NULL),
	('b8b24044-77c3-4aea-ad06-58ca84ea2741', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/WHTVWF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:25', '2025-12-06 03:18:37.137822', 'SM37c793fb4b41ec6b1bca921cb0b86350', NULL),
	('8b1a05c1-9df2-4b6f-ae10-342d101b8c1f', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/SFGIUQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:26', '2025-12-06 03:18:39.936045', 'SMa1e668a6a0175ac93831dce006a2ebcb', NULL),
	('13441ebe-a76b-4b6f-9893-747502da861a', '7a9928b8-a216-413c-8619-908f0e0d865d', '+33600000000', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KCCQZB
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-06 03:18:21', '2025-12-06 03:18:29.65817', 'SMe362bb01fe3407964f0dcadd0a7f7212', 'Erreur de type 30005 : null'),
	('cf902bb7-d9a1-4655-af8e-6123ebdcba5c', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/IDYLAZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:20', '2025-12-06 03:18:31.505431', 'SMba6dfadbbf85082f8c250975f2751a2b', NULL),
	('a2a3fa0b-47ac-47ed-ab58-57970e305788', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RTNLEX
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:21', '2025-12-06 03:18:32.653122', 'SMf464b80850f497239f52c8e29ba07e8a', NULL),
	('4dade40a-4050-42a1-99e9-4f22ecf60bb6', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MNIFMY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:25', '2025-12-06 03:18:34.945834', 'SMaad45da9764a5645c344a7ab34a1b674', NULL),
	('427c9d7f-58b2-4b4d-bf06-582b132b742d', '9f874782-653f-4272-b659-090ed53cb7f9', '+33783064624', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KJVQCV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-06 03:46:25', '2025-12-06 03:46:34.044', 'SM3e6633ac94605397e41ffdb1c35defef', 'Erreur de type 30005 : null'),
	('62b1b5d6-07e6-4ca6-9e34-2c4c32f65dc6', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/URMPRD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:23', '2025-12-06 03:46:35.341698', 'SMfb0d761da9eee9a406e36a6c0e93c055', NULL),
	('5ee97f7f-3f70-4ebd-a20e-0d8b5103a63c', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DGFJJB
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:24', '2025-12-06 03:46:34.06575', 'SMc2b16dec89e46dc7f3636d10cb145da7', NULL),
	('e0b633b5-396c-47f7-b3e2-8faf5ff7dae5', '91af7307-0c46-4276-8349-de60962d0017', '+33786020489', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XPMMXQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-06 03:46:27', '2025-12-06 03:46:35.838442', 'SMfe64c236c73664660c4eb76c09bcec5e', 'Erreur de type 30005 : null'),
	('46ecba59-40fd-420a-aebb-a7d1e368445f', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/WEQLWV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:28', '2025-12-06 03:46:37.843602', 'SM426d0fd9085dd05a3473e8794ebf8a40', NULL),
	('bf78d589-ba37-4cfa-9227-4ccae28a01eb', 'a43cce16-e1d6-4c13-b440-0499a81de6f2', '+33663787744', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RTBARW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:23', '2025-12-06 06:27:42.630273', 'SM350872d90aa77e7f345212171fef9ab6', NULL),
	('dbcb9ce1-0079-47b0-bc1c-a6c521fd43ef', '1599f73a-81e9-4a1e-8dbf-181773065bd7', '+33687346570', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PKYGFD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:26', '2025-12-06 03:46:36.046649', 'SM9cca2b4ae18a913efa5b7b91b262a54a', NULL),
	('9d47cfd1-7776-4fcb-b78a-1de98d1f0f59', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DUWEEU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:26', '2025-12-06 03:46:37.093826', 'SMa826bead91752beb4633ec332f146aa8', NULL),
	('977dfd94-bd16-4664-aa69-5f9ba99bc48d', 'aa585d61-6ec4-4be2-b637-b0cb16a830cb', '+33679159125', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/OFUTCV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:29', '2025-12-06 03:46:40.211481', 'SMdecdeba265d40970ff485ac36876e5f3', NULL),
	('1acaa3e7-a4be-4276-ac10-4c2fd32b63c8', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XBHJUY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:24', '2025-12-06 03:46:36.046066', 'SMeb220bbad119dfd12d556b49e6b2b567', NULL),
	('917ddbbf-2d25-40f5-ab9d-bc9200d2c5c8', 'a2e94284-c225-4063-8447-11175e49f030', '+33647787728', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/OVXNKZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:29', '2025-12-06 03:46:41.233607', 'SMb94ba68252294a485d705d89a7b05860', NULL),
	('fbd60357-dfc8-46e3-b305-84ebaf5d2468', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ARSROU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:25', '2025-12-06 06:10:54.955895', 'SM19d4d9afc9ab07061ffccbcdca596d96', NULL),
	('eca63fa2-878a-4ec0-bcb9-e115883d72fc', '06f72afb-571c-470a-9d04-ca83edc9010f', '+33662353483', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HPLJMD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:23', '2025-12-06 03:46:33.388349', 'SMf6b831e44956176332765969182e672e', NULL),
	('70b727d5-833f-47c4-b4a3-8bdea32b5633', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PFATCY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:28', '2025-12-06 03:18:37.900563', 'SM828616dd2e35ac21d77aa09078b5b4fb', NULL),
	('72026223-53b2-4fbe-909c-11fb75c0b7be', '3af6f2b8-1760-4d5c-b08c-7e100d33335d', '+33771271612', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CGAUOJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:29', '2025-12-06 03:18:38.715507', 'SM4811ecadf42a8a85ece4fe9ee0d0ce7f', NULL),
	('73a26389-e504-4e65-ae6b-444ae91ef50b', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UVICCS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:31', '2025-12-06 03:18:41.821491', 'SM510b7eccff5765658fc1ed0304f9adc7', NULL),
	('2293ed47-f5c1-4181-a423-18e835ce8051', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PMPNGC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:27', '2025-12-06 03:18:40.22055', 'SM79d59a9c14b492776b0522531c5dcb0f', NULL),
	('06672cd3-d943-41e3-b8a2-946abfd44920', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CWSQCP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:27', '2025-12-06 03:18:42.976015', 'SM4f73c1baf19b7cb9bd580f8dc771bfce', NULL),
	('a8cc5d9e-f84a-47a9-926d-e3fdf4a38e73', 'a543bbd8-04ae-4074-bc43-10de8c0aba69', '+33661868329', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/NSQYCQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:27', '2025-12-06 08:08:11.385352', 'SM5764670957c1ebe5193ffa8be765792d', NULL),
	('129b58ab-acb3-4307-803a-fc830c9ff80b', '86834cac-f4fc-44a1-b536-f3d38643c835', '+33664538190', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MRMTKJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:28', '2025-12-06 03:18:42.775427', 'SMf029edcd65c080961fd0ee19073b90ee', NULL),
	('84d7f863-6bae-4845-a6ff-974963c121f0', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/YKSLWR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:30', '2025-12-06 03:18:41.911225', 'SM32f7d2b64e2856cf2fd0a0f6bd669c6e', NULL),
	('e6172042-a6f6-4403-981a-ea151094bef0', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/REKRKS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:27', '2025-12-06 03:18:42.022395', 'SM37e9e60a637fbf786cfca42372475d01', NULL),
	('1a6d7272-2bc1-4098-b27a-e98a9aa792ae', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/QYPPEQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:31', '2025-12-06 03:18:44.029161', 'SM11e6109990190673db150d0b27da8b3f', NULL),
	('08ef229e-63e8-4d1c-af6b-2219b2bead77', '0840c04c-05c0-45f8-ab6c-e2778a3b3744', '+33634277641', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZIPLXH
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:29', '2025-12-06 03:18:44.496567', 'SM2fd9ed53bbdb1b0abee7bc832dd139e9', NULL),
	('837f52ed-872c-4f66-82f1-65a0b641b304', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/EXYWSF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:30', '2025-12-06 03:18:44.366095', 'SMb0cf902536370f1d2010930fc480329a', NULL),
	('fba48a72-5b53-41ff-a380-6ee18385dde3', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HIFQYY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:26', '2025-12-06 03:18:37.328514', 'SMccd329f5b70e7d9e064874ca1df849eb', NULL),
	('a8efa65e-cd66-4cf1-baa9-764f87abf238', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HHZFLT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:18:29', '2025-12-06 07:16:51.925955', 'SM50309b5181d28ade77a58963c015954e', NULL),
	('884c427d-0d43-481b-8f82-408f9a5419fc', '58fd23db-ac36-4dfe-aa28-e93a9e7797f8', '+33615072092', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XTHYAL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:21', '2025-12-06 03:46:31.652828', 'SMde347a98b3a5ee9d6aeae2fdeb45111c', NULL),
	('309f3a47-9223-4c32-a09b-4e34bd0f2a35', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RYYYBN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:22', '2025-12-06 03:46:34.263207', 'SM80951cba527cf2f25148e64e8a37ec59', NULL),
	('2e78510d-f3a7-42ce-8abf-7e6ed4d9312e', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CTGNXZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:26', '2025-12-06 03:46:37.351484', 'SM6d7f4fbd3faef560b8086e9cd609d9a1', NULL),
	('989e5f3c-3277-4149-8907-22e23684c2f5', 'bcc324ce-5e1b-4b6f-ba3a-e56aacad6b71', '+33681432541', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/WSUANE
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:28', '2025-12-06 03:46:38.442436', 'SM4b727e2bd15caa65bf54a4a293935021', NULL),
	('82b0f9d3-3782-48f1-8630-c6d4ebb00bec', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/VFBTHO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:27', '2025-12-06 03:46:39.355502', 'SM3b30ab7e50c68714e67298f914e9044f', NULL),
	('eff44170-5b2a-4a47-9315-be846bbbf170', '0f8d6245-a78e-4854-9ec6-bbbc18887277', '+33677915553', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/QVRWUT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:35', '2025-12-06 03:46:45.06888', 'SMcff07bcc63f9bdf32d90f091961f8454', NULL),
	('96ad1733-94cb-4ae5-9325-dbe79a6597ea', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PNXYXF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:39', '2025-12-06 03:46:51.349091', 'SM4aa8e96aab7f75b52837a96031954e11', NULL),
	('5234484d-e236-46e6-84a9-99ba6de7b347', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MKLHKU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:45', '2025-12-06 03:46:56.610706', 'SM3ad8e8425fcbc2c9d9a63002e5be2333', NULL),
	('c595cec5-8872-4df5-8f1d-ed6dc8ee0e12', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PTKJRT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:30', '2025-12-06 03:46:40.564072', 'SMc79714fd0cc3752e249e762465311892', NULL),
	('51492d3b-7d57-40f0-addc-2f10ae383ef1', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HQHJON
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:34', '2025-12-06 21:07:56.479575', 'SM7aba491fdc325e41cdca12de243c744e', NULL),
	('4c357de9-7cc1-4d9c-8eda-9f5a74f9dd44', '22b64c3e-9e33-42c8-b0c9-be02b47bdd1f', '+33608035361', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/VGIGGY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:31', '2025-12-06 03:46:40.899712', 'SM06377ba18f82a12e60d4f3cdbed403c2', NULL),
	('6969e82c-44ea-4f0f-afa2-0556b2856075', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/GXOUJA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:32', '2025-12-06 03:46:42.42729', 'SMa33c30602a23caa3771e6c4857bc4723', NULL),
	('c5959d89-85c9-4df3-a9a7-8f11027fed59', '35ea7b95-05f1-4541-8f4f-e707ebb36f26', '+33675275474', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/LLBDBA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:36', '2025-12-06 06:29:18.525571', 'SM473948ef7d8d6f3f7d81744c6a408fdc', NULL),
	('24637e69-263b-4487-89f1-603049fb819f', 'c76145f4-3bbe-420a-9873-1410b3b7aff4', '+33670667723', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/FRESIR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:33', '2025-12-06 03:46:42.965075', 'SM285df829bf1d35ce2bcb78d2071d7433', NULL),
	('ba2bfec0-7837-4a32-8a00-93c01c06f6dd', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RSOFXW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:35', '2025-12-06 03:46:46.904239', 'SM8fed06b629df67b43fead38784e8a482', NULL),
	('b1a6a771-eebc-4b09-8f5a-134578667475', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DKMGFS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:33', '2025-12-06 03:46:43.583064', 'SM3f9f60afc1979e642778af0b288d3e82', NULL),
	('313a0717-6e31-410b-969d-6bfeee772443', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/IDNVJG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:31', '2025-12-06 03:46:43.808111', 'SM25e12b84318405bd80ca79ec79e41414', NULL),
	('be9b15b4-6c58-468a-98dd-d7d526f285d3', 'e1df6234-d0fc-4906-bb82-fa0e7d8a24ec', '+33607430571', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/VNOJIQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:32', '2025-12-06 03:46:42.988416', 'SM562ea8829571439012d97654c3a47a18', NULL),
	('820bbe66-1c6a-46e2-8dd4-4b3174a81e88', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33615434343', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/HTDPHT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:31', '2025-12-06 08:20:45.784783', 'SMebecbaf9f8ee3dda0662cfe4bb2db312', NULL),
	('3cacb91f-0993-46cc-be13-ba97cd12443c', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZZGKPQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:30', '2025-12-06 05:22:31.404653', 'SM1abd17adec21a288289a43df9db58ea3', NULL),
	('9e0bc13e-0cd7-468b-b0e2-f72294a3401f', 'f570075c-a0f6-4f85-9697-4a313d73bcde', '+33661249828', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PMQIJT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:34', '2025-12-06 07:56:56.738021', 'SMd18b62128c54123dab2355a50c657618', NULL),
	('77c8f957-df6a-4197-84c4-148508c5a50a', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PXUZGK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:30', '2025-12-06 03:46:39.970711', 'SMb15095838e68c49caf3716fd09d3be67', NULL),
	('6037e1a7-a983-4c06-a7f2-13433e099cc2', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/LODSQW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:37', '2025-12-06 03:46:48.063045', 'SM28dfac5987d2ba3bbc268e53497d929a', NULL),
	('3db28f84-26db-4bdc-bcba-43b0395f6804', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UHSKQA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:37', '2025-12-06 03:46:49.513806', 'SM42f23e1fd467493e35c3318066c932e8', NULL),
	('7519b1df-0b3b-4ee1-b66c-48f8fcce6123', '92470fa0-c720-47d4-94a1-ce68637c18b3', '+33614392050', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RQLNAV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:38', '2025-12-06 03:46:48.278406', 'SM84e54f7931f9c5979856278c5ec1e7d3', NULL),
	('03be9748-918e-4388-a74e-1f07b8364d96', '16271680-19a8-4184-a754-337364221875', '+33673426632', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/AGLEEW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:38', '2025-12-06 03:46:49.52163', 'SM8171fb5f52cc99c317ee5002b71a1eb4', NULL),
	('16e17c91-7fdc-4c4a-8812-4c729ea3e841', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/EUUGMM
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:39', '2025-12-06 03:46:50.131387', 'SM33399e07bde3b505e5d3e884f1fe4c1c', NULL),
	('464f6846-f616-4f16-9b59-61fbba5689e8', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/QMQSHO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:36', '2025-12-06 03:46:49.662666', 'SM820dbe0834dd8d02f248f1284c72ce04', NULL),
	('4a03bad3-4dc3-461d-90f0-4800bb186d23', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/OXWNGR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:40', '2025-12-06 03:46:53.905069', 'SMe1e7665786c867397d2e2929da269147', NULL),
	('55ac3488-9e50-4858-99ba-ab68e0448a18', '5a67bbe0-58e7-4d63-98e8-433df60e7e1d', '+33659706203', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/OZNWNR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:39', '2025-12-06 03:46:50.275326', 'SMb6a23f90e248da4903c8ac4f2ccf7405', NULL),
	('0e0117ed-8c22-4579-a340-fc361f81239b', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UUBOCM
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:40', '2025-12-06 03:46:50.199107', 'SM4c96710010d7290db24907c12c8df1c3', NULL),
	('1154370d-d01e-4537-ad9d-63531826fe71', '84aba313-5d27-48c0-96a6-6f99441becc5', '+33632764948', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MABJQW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:40', '2025-12-06 03:46:54.254464', 'SM157eaeb03ca46b921ac169464376a163', NULL),
	('8cbddd38-1b13-4e18-870b-99b585d838d7', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/KCSIBT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:35', '2025-12-06 03:46:44.98465', 'SMbccd578968ed2f96f53b99a6545e376d', NULL),
	('fed74801-181c-456c-a0e4-a28784e505eb', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/GLEGFJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:41', '2025-12-06 03:46:56.689715', 'SMf36b4de42b076a2c018de8393c7feff7', NULL),
	('ee9891d0-74f6-4bfe-9ee9-0b784ef1aa6e', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/GCSGGU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:41', '2025-12-06 13:13:24.661868', 'SM8664302c0ceccf4cf7ba2a6ef812223c', NULL),
	('c7c8d237-7223-4f67-8ca3-6e054bfbdd5f', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MRCNMG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:38', '2025-12-06 03:46:47.166825', 'SMfff0d5e38b47bcf01eb8b8da45e05c64', NULL),
	('b1aef5be-2fb5-4b27-937a-691557cff0fd', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DDBWOD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:43', '2025-12-06 03:46:51.645718', 'SM6f0c3a0fa608a1271c04954ee222ac18', NULL),
	('58632ae8-b302-4b88-ae36-37e4164bb4d5', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/IAJSOF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:46', '2025-12-06 04:14:13.03075', 'SM5aeb3ef57efa3442957a13742f63d876', NULL),
	('7ea3f7ae-bae8-439a-b4e6-7e4d2194e521', 'c013befe-a972-44be-86de-7996756f4402', '+33777073500', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CPRVMI
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:42', '2025-12-06 03:46:53.724374', 'SM4c1b3f0f8655a147cb6a44ed757fb0f6', NULL),
	('7cf3246a-2045-4699-85ee-af8603a56864', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RVLJBP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:44', '2025-12-06 03:46:55.16667', 'SM170d5cf30df6f3f7f3076c68add10eb7', NULL),
	('04c2f1f0-8d62-42da-a180-9a3ece3bc8cb', '5e9ef7b0-872f-47f4-ae27-386fe5db7c3c', '+33699047451', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/TBWCAT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:46', '2025-12-06 03:46:55.652046', 'SMad06c06a41f9792b2f5b4d65945ed307', NULL),
	('cc8b5d99-c8e0-4b17-8dba-e32669797c99', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/JBHLNG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:44', '2025-12-06 03:46:55.563122', 'SM0c96ae340dc296294755d6156970e088', NULL),
	('4f8ddf70-b6b8-4bee-a8a2-ca07fe628f9a', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/PTVDQP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:46', '2025-12-06 03:46:57.086557', 'SMd0f7c23bf6516de048f74e4b4eed0870', NULL),
	('9d900ab9-6d05-4346-9f33-4744949b08a2', '8d141563-9b62-4b6d-a7c6-b7851d63a519', '+33687450613', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/CAVVQM
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:43', '2025-12-06 03:46:59.650049', 'SM7e5e495de6bd89eb9e445da9d0233e57', NULL),
	('dd35d801-e0c2-4d75-9bd1-1aa5527362c0', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RNSXVQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:45', '2025-12-06 07:01:37.782413', 'SM33fbaefafbb18a8ecc74f38220f2b4d0', NULL),
	('b8ff71d0-f7ee-4295-86f8-7e19ca107747', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/GMDJCS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:44', '2025-12-06 03:47:00.565349', 'SM61c39f08d2cd49cd9a88c6c8c49a8c91', NULL),
	('f32a59aa-b918-45ab-a976-51a1e5dd7332', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ISRUOW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:42', '2025-12-06 06:10:49.797685', 'SM3eb8e246632d0ae50b48cf90d2bdc146', NULL),
	('b8770705-9a43-4afd-a2b4-37859eb952a6', '2cd0c3ac-b710-4f8a-8791-33eab9142483', '+33610220533', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/DQJEUZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:45', '2025-12-06 03:47:02.326725', 'SM20fd8d62714dd1a514b774bda7db7a11', NULL),
	('9641d2aa-f6db-4544-b818-27b8f422ad66', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/JKIWXV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:41', '2025-12-06 03:46:51.624797', 'SMaaf7851da3ca4d32a01157a47ea157ef', NULL),
	('8c18befd-4379-46c3-bdd6-54b6a1bbd711', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MQCXCZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:43', '2025-12-06 03:46:53.405218', 'SM0d0fadc6678ddf6cd6940a158c033ebe', NULL),
	('ea6475a9-dcfa-4b19-aa3a-3c2ac19b6c58', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZHMDAA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:50', '2025-12-06 03:46:59.585426', 'SMebb435b9f5df20d52ab3f2993ca64ede', NULL),
	('6e4959bf-ecbf-464e-9428-34e4c4ceb2a3', '638e9607-ce5d-465d-b39f-1671ee6dff09', '+33612400854', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/MVIUEF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:50', '2025-12-06 03:47:00.025425', 'SM5301f8801d0dd245cffb09711af24ab3', NULL),
	('49d54e23-4ad3-438e-8759-b7f345b187be', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/LKZJQB
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:49', '2025-12-06 03:47:01.522685', 'SMda804d55e450c9939a44e249c504ed35', NULL),
	('b86605a9-564c-4183-88a6-807680d611cc', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ETRLSD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:48', '2025-12-06 03:47:04.405771', 'SM41631235268987a27bd95c316431784f', NULL),
	('6a2761cd-0189-4f6b-8f5f-15139ab2dea3', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/EZVKFA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:51', '2025-12-06 03:47:05.664337', 'SMa086de925395cef2238dcf565cf677fc', NULL),
	('880fac91-4cf6-4c94-8007-899dd41e9860', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/YCHTGA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:47', '2025-12-06 06:54:54.659292', 'SMedf5d959b5beab654334453e3a0dbdac', NULL),
	('882f9ed3-02c1-4bc7-ad39-17d2913b70ae', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RTUMAC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:49', '2025-12-06 09:03:31.90499', 'SMd6659fd0f1d15c16717a4069e5f709b8', NULL),
	('32984ff2-a6fc-4b8e-8206-5e29fb919c43', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UQCUWA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:50', '2025-12-06 07:50:43.171624', 'SMf676cfdaf14a1555153e073bc69dd130', NULL),
	('99b143ea-15e5-44fe-84d1-8879c68c4d8e', '9913046a-680a-42fc-8c33-1c7cc517aeef', '+33659200650', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/FGQCZG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 07:42:40', '2025-12-06 07:42:50.301567', 'SM5089c620fccf9b6bacfb75038dac6eca', NULL),
	('0ec7d502-3300-49c2-ad43-d889a58d839f', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/RUVMKD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:48', '2025-12-06 03:46:58.359158', 'SMa8cab33dba2a1e45b5ed30cd466f2843', NULL),
	('a5cbaced-94e5-4614-8d11-ee42b4d92694', 'f3087033-2aaf-4c80-b2b6-2706bf5d2f09', '+33610961982', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/ZISQIG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:48', '2025-12-06 03:46:58.574747', 'SM17709efb4b7bf4e46a9bd6f69f3d50cd', NULL),
	('eb43fe52-761f-414f-8831-28c04a77a247', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/YSIJAA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 03:46:47', '2025-12-06 03:46:58.765511', 'SMc1c1643970c353fa4aba6921e64f194d', NULL),
	('298e17b0-58bf-4a2f-b957-d7846a74a957', '3763b3f6-9ace-4ebd-8a7e-eb0ec27e40dd', '+33616798932', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/XJYMIQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 08:48:53', '2025-12-06 08:49:02.122491', 'SM3d3b35008c3aae33e5cf75fed5ef5c86', NULL),
	('2c9756ee-6159-4b98-9b8a-8f3af58c5a6e', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/QXPQXC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 09:05:42', '2025-12-06 09:05:52.650312', 'SM6a9fd132ee03d23e7f54a48fd4b147ad', NULL),
	('2a46468f-44d9-4996-979a-3df389c96867', 'cc6be365-6e48-4469-b86e-4b92265778fc', '+33629332926', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/UENCYW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 09:15:16', '2025-12-06 09:15:25.619185', 'SM6ce1f0690c89e230d8423eb8fae439d6', NULL),
	('3ad9dd87-76aa-45e9-a370-d8c2d9b14a9a', 'e5ac925d-9240-4a5e-b935-b55bb80911cf', '+33606368422', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RVRVEZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-07 04:55:55', '2025-12-10 04:56:03.478623', 'SMfd2bd216368cb06cc0aea3e23ae1f8bb', 'Erreur de type 30008 : null'),
	('29f51d9e-69b0-4f59-ba68-a449dae6c17a', '691203e0-1a28-4c25-aaf2-a47eed1a03f7', '+33627261147', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HTDPHT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-06 19:37:22', '2025-12-06 19:37:32.089008', 'SM1797864d0ba8e1adc0c853bbddffa779', NULL),
	('0cf62532-7600-4222-8067-d2b190d1a7af', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HFHGBK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-07 02:11:25', '2025-12-07 02:11:36.460854', 'SM9dd7f1adfbe7d273339e3441c7de3aa5', NULL),
	('92a14de8-52f7-405b-9262-ea8bf2b7cb74', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SETJQA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-07 02:11:53', '2025-12-07 02:12:39.648854', 'SM7d43f2f3047b552ca3bad30f01930a68', NULL),
	('5c2bd417-6014-4b67-873f-a3b71353f14a', 'ae764e76-fb96-44fc-b1da-28a2a8d507b0', '+33638937416', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QRCLMN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 01:30:10', '2025-12-13 01:30:19.496699', 'SM16baa01b4c2fcce1f3e9fb7f73db9500', NULL),
	('af25b275-f072-4902-9dc6-dc7aaee600ed', 'e4f45475-565e-40da-a9f4-bf7afee5e649', '+33638937416', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/OTJEQI
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-07 04:58:20', '2025-12-07 04:58:28.079838', 'SM8a446017a14900a26ef98b06b3380d13', NULL),
	('fb940f25-fdc2-4821-b0c7-166dbba8da39', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BGZUUX
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-07 04:56:10', '2025-12-08 06:57:20.006573', 'SMb69b50335384208c31d45be514b6abda', NULL),
	('74d26c70-b9d6-4cef-8f45-3f4b531a1e63', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/KFKSEU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:44', '2025-12-13 10:36:44', 'SM1d3172c8f9f748623dadf52c00acc5f7', NULL),
	('9156f933-17f2-4450-9e94-048baf202ffe', '970c6a61-0010-4770-8ff2-a3b703e5cc8c', '+33638937416', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/CQQVQP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-08 13:32:33', '2025-12-08 13:32:42.286462', 'SMb49b4fa2d690f0c7f4fef9d6df7248b4', NULL),
	('9236d933-3a94-41d8-bf28-5f86f390fde3', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ARFSDN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 01:29:49', '2025-12-13 01:29:59.468613', 'SMec7c146526127bef3b5a66ee943b81f6', NULL),
	('30cc5431-9f58-4976-ae7b-069745118af8', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZBYMEL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:45', '2025-12-13 10:36:45', 'SM836af4bf03aa9eb12ac5b067461c5af5', NULL),
	('47b5d05c-0aca-4b24-aa73-e9b9c6d2502f', '16271680-19a8-4184-a754-337364221875', '+33673426632', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/AGLEEW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:44', '2025-12-13 10:36:44', 'SM4a76d5e69c8431e4cf2ae12ec523d98b', NULL),
	('0db13691-cba3-4e04-8613-752692bedd54', '83d8b6a1-7494-4643-b500-dcfe7f887380', '+33683173610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/GMDJCS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:45', '2025-12-13 10:36:45', 'SMac4dce397375f36a10b8f79b3828740c', NULL),
	('2d145a70-1dbf-4a7d-b8b7-c587f06b5a34', '1f416c0e-68f3-430f-8558-427275a45f61', '+33684751677', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/CWSQCP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:45', '2025-12-13 10:36:45', 'SMee24086c0ea6ae9739202a8ef449c23e', NULL),
	('4adf6667-1c45-458d-8f11-e034db995bcf', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HFHGBK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:46', '2025-12-13 10:36:46', 'SMa4e6ae6efd6f36cf80e1269c70e79fcf', NULL),
	('08ea03b1-a2e0-437b-bb5d-7ecf51d40d8c', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QYPPEQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:46', '2025-12-13 10:36:46', 'SM1f5a240eb6d02918dc2bc33db55ea9e3', NULL),
	('0304b95a-cf7d-4c57-af78-322155519bef', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YKSLWR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:47', '2025-12-13 10:36:47', 'SM1463ca3cf8531960ec3f869b4c538a43', NULL),
	('4d6bf4d6-64e2-45d7-b76f-8383d59bd020', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SETJQA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:47', '2025-12-13 10:36:47', 'SM5e4b05dd46744aa5aa988e0c57331fd1', NULL),
	('b8f0ccd4-8e3b-4643-abd0-80a63468a623', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/LKZJQB
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:47', '2025-12-13 10:36:47', 'SMbef1da92b120f80923f7bcd7984a8390', NULL),
	('775e616f-04cf-4523-8f1c-fa7e5313458c', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DKMGFS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:47', '2025-12-13 10:36:47', 'SMecf26c9b1916d6275ba5ed4a242405a9', NULL),
	('b5cccd4a-aa8e-4198-b1db-39ae4e97870d', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XBHJUY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:48', '2025-12-13 10:36:48', 'SMa3819dfbcc587f9e031cdc7940fad476', NULL),
	('8af43b48-c206-469a-b6de-bc1fe42a20d1', 'c0308668-8d76-433e-9855-22b0e3ab59dc', '+33672341680', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/GXOUJA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:48', '2025-12-13 10:36:48', 'SM4cc386d02649e76bcaa03cfb3acc092f', NULL),
	('f7398bfd-03f5-48b0-93f0-bbe546aea498', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SRMBHN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:48', '2025-12-13 10:36:48', 'SMd392e70dc71470c99b5fa48c89d68813', NULL),
	('dbfa3a19-ed50-4ac9-9054-b41b4b693c4d', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/AVYHQD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:49', '2025-12-13 10:36:49', 'SMd65259d298cc78f45fa54720e7a5128c', NULL),
	('a6e79642-0867-41ee-bc1f-f3055dcb8900', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RYYYBN
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:50', '2025-12-13 10:36:50', 'SMba1c45830a656f9779ce7ec773bacea6', NULL),
	('e8090bfe-7592-4789-b80f-31e066739dab', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RVLJBP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:50', '2025-12-13 10:36:50', 'SMb2c0018a2a4bc7afa3900125ccde8c96', NULL),
	('a5b03d4c-58a0-4e38-bdbc-971be5578479', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HIFQYY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:50', '2025-12-13 10:36:50', 'SMf7506824a49ee37b6e19f9913774cd61', NULL),
	('fbacb8de-f1a8-46f3-8161-66772cd6bf78', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PNXYXF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:50', '2025-12-14 08:24:24.539805', 'SMc12461c43da48090ffc48a36b8d82205', NULL),
	('d37e9ab7-9991-4b58-81dd-d900759d911e', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YCXMMI
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:51', '2025-12-13 10:36:51', 'SMf43b4edfb40f0de0e9f3b9977b8c018a', NULL),
	('a05a351e-a229-4925-9af8-f63950665d8f', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QMQSHO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:51', '2025-12-13 10:36:51', 'SM4d5cfc720813c660bc5f51087dd2746f', NULL),
	('a86a5e7d-f3bb-49c3-8cda-bbe8b66c876b', 'a0434ad6-faa7-4503-9db5-a32c64fd3e6e', '+33785599530', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EXYWSF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:54', '2025-12-13 10:36:54', 'SM59c13c26d0881737b653f41479dd5fee', NULL),
	('32227c6f-5616-451a-b62f-b498736fdd0f', 'cd03d583-dba6-40a7-8aea-261d734daa45', '+33677752218', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/VFBTHO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:54', '2025-12-13 10:36:54', 'SMe06c38c8106cd59b5e2dfaf19b114127', NULL),
	('c309dd92-aea6-4d6b-a4e9-36b26ec84298', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SFGIUQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 0, '2025-12-13 10:36:55', '2025-12-13 10:36:55', 'SMe6ce4aff8fc25886714787b84a636e8b', NULL),
	('e103f520-b975-4666-949a-a6a279f04e59', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZHMDAA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:53', '2025-12-14 08:20:19.547086', 'SMc9f9d8db5aaf71e8485ba3ff78db8ae2', NULL),
	('b47633ac-b1dd-490d-be28-4dad64143e55', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MNIFMY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:52', '2025-12-14 08:20:38.75813', 'SMcf13ab9e3798c2cb2596af7339e8f0fd', NULL),
	('1f908228-6940-4425-93f4-a46fa4ab8523', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PFATCY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:52', '2025-12-14 08:21:59.545334', 'SM143b15714d69c4ffa09ec285fcd410de', NULL),
	('a6c4b0cb-f025-4aa7-8b31-2678611ee47f', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ELHDPY
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:55', '2025-12-14 08:22:34.512355', 'SM6bce024ef312da847db44fef52b5b547', NULL),
	('3e060cdb-0357-4e72-8f94-51e77122b345', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/IDYLAZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:53', '2025-12-14 08:22:41.356274', 'SM643e8e626411c1841686d31eb4f56c51', NULL),
	('a73a9a21-14ba-40a7-81d9-c42d2665d890', '742f15ee-f9c1-43a5-821a-ccf08bec61a3', '+33644101315', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DDBWOD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:51', '2025-12-14 08:22:53.091425', 'SMef61db6c23f0dbb2056ceae52a974206', NULL),
	('aedabb35-36eb-41b4-bc6e-e2c3bc2f5f20', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RNSXVQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:52', '2025-12-14 08:41:51.525178', 'SM9c0761d2552f9547ee0bac1b90de031e', NULL),
	('1d49d258-f900-4538-ae6b-2250f5d901ac', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/FCCWTW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:53', '2025-12-14 08:41:55.494191', 'SMa2c2e9c5833e56214dbe4c7d0f3cb195', NULL),
	('eb5d033f-6e34-4d77-b688-43e48ab4470c', 'f5cbddca-eebf-4432-8afb-0f84c8c2f217', '+33661499794', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YCHTGA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:54', '2025-12-14 08:41:57.699888', 'SM899b475e9098aa0578017764e3d40a6b', NULL),
	('9e11f604-988b-471c-ad86-b76a575171b5', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/NWAZTK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:01', '2025-12-13 10:37:15.666414', 'SM9f69ffd867bc71ff452b34dfedcf816d', NULL),
	('d79166b4-383e-4483-995d-953d941555d2', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UALFFU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:57', '2025-12-13 10:37:15.961581', 'SM836c014090b0b0ed8ddbfd421c474986', NULL),
	('fb4c36ad-6ef0-4372-914d-cef2c2ad1825', '40eb6f55-8411-41c1-8ca3-ec6afef5b318', '+33664968387', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/CKSTQR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:56', '2025-12-14 08:22:43.031999', 'SMc8e8a3ea19a7183d40c0401d08be8296', NULL),
	('ed8b4f37-18d7-4193-95e3-e3a46219ba1f', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ISRUOW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:57', '2025-12-14 08:19:44.857731', 'SMf38e510e3e5f8739e29466f0324dbf50', NULL),
	('4875d114-b1ec-484a-a9ee-ce0c4df73a51', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UVICCS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:00', '2025-12-14 08:19:47.029016', 'SMa95901f670cfc22e6c02d907eb650de0', NULL),
	('7fd885c0-dd69-4db9-9424-b910f855384f', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PTVDQP
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:59', '2025-12-14 08:20:17.380999', 'SM3655ed0bd7af753b37ba932f2eddb3db', NULL),
	('ce9f0266-027d-474e-a4ba-7ac136c144f1', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PTKJRT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:58', '2025-12-14 08:20:54.064411', 'SM3499136779d8c47170df8d27d53207c4', NULL),
	('f3f33bdd-d7c9-4dba-8e2d-37bdeefc842d', 'efe3d9ea-5c59-4c10-94d9-5ad5e711be32', '+33612470381', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/LODSQW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:58', '2025-12-14 08:21:28.035344', 'SM8f22b83d80fa5f075aea2c04b4e1caab', NULL),
	('925ab6c2-c662-4179-b6a2-dd241a2133f5', '2311d53b-1bdb-4b6b-8cf7-8a2ed0d4ee45', '+33648374023', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PXUZGK
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:56', '2025-12-14 08:21:43.082219', 'SM286288d795611f903b089c0f7d4d65f0', NULL),
	('d2504365-7015-49c5-84c6-fa0090e3bdc0', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UHSKQA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:58', '2025-12-14 08:21:46.454824', 'SM9b51a789e9d50280cbe8052d095a04d8', NULL),
	('cc91df6e-e328-4da7-83a0-c7a78248396e', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/JKIWXV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:56', '2025-12-14 08:22:32.27286', 'SMdc27a122031f0ea74489d84c08a99b34', NULL),
	('1d420e3c-9b81-4caf-b79f-704f9f286ea3', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RTUMAC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:00', '2025-12-14 08:22:36.823733', 'SM8a7a447df5258fe7a943dc9a63591f96', NULL),
	('7f6828a7-fbfc-460b-a8cd-ec898e40cdaa', '0976c3c5-8505-490b-beb0-07e9999a9aa0', '+33650768107', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/LUURPL
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:57', '2025-12-14 08:22:47.823163', 'SM68c7080150ed832d9b8496c626ce8ffb', NULL),
	('d05d58a7-413a-437e-ac96-760d42eb3982', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DGFJJB
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:36:59', '2025-12-14 08:23:55.087878', 'SM14d9562e4ded9d234a9387e01c3633c3', NULL),
	('43836483-7dd3-4c10-b2f8-ae60f317b3ad', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MQCXCZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:01', '2025-12-13 10:37:14.444577', 'SM34ca4c08e7462633cbfe7cbbe2bab9c1', NULL),
	('b6f1ca54-7764-4107-997d-eface8da0c4e', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/GCSGGU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:04', '2025-12-13 10:37:15.319387', 'SM1742b670e97bda82d3ad6a7159fb3f17', NULL),
	('b5676b50-9d59-4867-bb32-669180f021e3', '6d5e0bb5-60f6-4ddd-94f7-d827d806117e', '+33698046114', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HYUATR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:03', '2025-12-13 10:37:15.521676', 'SM31e382dfb6a69b0bc498bba6638f00d9', NULL),
	('9951ab82-45c8-4d33-9d1d-4212baa500a9', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/IDNVJG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:02', '2025-12-14 08:22:45.413171', 'SMdf877b11995aa20446d89db01a0e3b8a', NULL),
	('d5e1191d-3a9c-48eb-94cb-a1a3f4eb4592', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/WEQLWV
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:03', '2025-12-14 08:22:50.109812', 'SM5c617165f1c058b965bb6c595c037175', NULL),
	('5688ba12-0955-4d55-b910-e215f03b178c', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MNYYLJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:04', '2025-12-14 08:24:37.475061', 'SMa1b68dfd2d1547c73e5b435661a9a528', NULL),
	('412ca2fd-aeb1-43f8-b115-31563f086ba9', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DNFRFO
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:05', '2025-12-14 08:22:02.690142', 'SM2e1b890e9d45a8648cba13465aedef92', NULL),
	('4a078bf8-ce37-4826-9a75-2183f78dcb6c', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PMPNGC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:05', '2025-12-14 08:21:57.014132', 'SMeb575eea61b41a9974e4d8273c0e5d47', NULL),
	('efecb3b2-c278-4618-a56a-e8945042690f', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RUVMKD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:03', '2025-12-13 10:37:21.46036', 'SM05d98319f270e354a007f57f548569af', NULL),
	('4b7f3875-3c56-4f1f-8e09-56da135b39f4', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HYISTJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:01', '2025-12-14 08:21:32.134793', 'SMdb0ea26247ce94bc8dfe876475575910', NULL),
	('e8828b84-3f18-45d0-b882-6d7652d6bab0', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZQFWHQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:02', '2025-12-13 10:37:25.063259', 'SM14497ffac5f447fb7631f4482255dee8', NULL),
	('c881c250-835e-413e-8050-c4f04e9db754', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/JBHLNG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:02', '2025-12-14 08:19:31.808989', 'SM41eb049d5d971814abdfad0484c1d2d0', NULL),
	('58b69523-c422-411d-b04a-d98df6a8b8af', 'f0897ee7-b7a0-4566-8bc9-b8afb95a6ff8', '+33627657584', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ETRLSD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:01', '2025-12-14 08:19:40.485793', 'SM784b1b0abd1a3459e8285bd9a10c1f84', NULL),
	('d81eb838-6536-4853-9593-1df4f7bb8747', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EJLAIF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:04', '2025-12-14 08:19:42.725518', 'SM7aba6f9eb75333a3ff15da2232c0b404', NULL),
	('403dd549-5b98-4862-8480-c58c3079a259', '1694358d-1b25-4a73-ac93-0ef533f4be44', '+33682433457', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/CTGNXZ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:09', '2025-12-13 10:37:27.719479', 'SM8089fdeb30246a5181d64382b54f4e8f', NULL),
	('d35162f6-6656-473e-b62d-56be3878cf5e', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RKPRCJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:06', '2025-12-14 08:21:30.080955', 'SMce0d3b631d4c9a0fda6fa7a4f621c4b7', NULL),
	('5e691045-4ce1-44d2-8956-86ed482b12e3', '27a46392-38fe-4150-8cb8-855b5e3d3556', '+33673262684', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/GLEGFJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:07', '2025-12-14 08:19:36.333881', 'SM8c68ac42fc915445ca814bce3d2af2ed', NULL),
	('3d40c98b-130e-4828-b44d-a19598dde838', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZYQXSA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:07', '2025-12-14 08:22:39.018342', 'SM5a7e693ffe756243cd48badcdb3cbf75', NULL),
	('acae88dc-f96d-44fa-bc53-ec77e1226d49', 'f939127b-f40b-45e1-b157-cc88f0af45a9', '+33787963172', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RSOFXW
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:08', '2025-12-14 08:21:48.6506', 'SMbc0c36c14d6aae977ed083cb6b43bbcc', NULL),
	('ffb71369-7aed-47a0-ad20-8a15953905ce', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MRCNMG
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:09', '2025-12-14 08:21:25.742979', 'SMad6272f9beb632ccbef097a1831629fa', NULL),
	('24b1677f-6e81-4dad-b4b3-5a3ce7008fb9', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UQCUWA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:08', '2025-12-14 08:20:51.921531', 'SM7545d7ec166ac521520c27620ea7c124', NULL),
	('4f67045a-a9a2-4873-8e42-1bb1f2a29866', '01cde600-5078-48b4-8d6f-94069c0fb7c3', '+33665759670', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/URMPRD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:06', '2025-12-14 08:21:02.993619', 'SMb457984f1db9603a73397e81a38f36d2', NULL),
	('ca9f6381-0b20-4af2-9f1b-e6a51668a68b', '537e2f3c-b831-4ad6-8b2a-e000da83d21c', '+33614590972', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RTNLEX
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:10', '2025-12-14 08:20:42.170181', 'SMf0b9cd8155445423ba54a90a756b5e9e', NULL),
	('780b0ae9-feb1-41fe-8026-1f3395fc58f9', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ARSROU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:10', '2025-12-14 08:20:23.726264', 'SMef696c4460d5735a31b26b98e9403573', NULL),
	('d8dde0a2-e5f6-45c1-a0fd-619cecc82aca', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZZGKPQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:06', '2025-12-14 08:20:21.740101', 'SMbf0c1c82948f74779e4654e8d9bfac3b', NULL),
	('971e5118-4a76-4d8a-977d-b8bb972bb0ab', '3f3547be-0221-4543-ba5b-fba485a0ecf6', '+33670523009', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/IAJSOF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:09', '2025-12-14 08:19:55.597522', 'SM7f40294d9b31d167e61e53b12e52ab65', NULL),
	('0552b424-df11-4d73-9c27-56c2a818c139', '2875e641-45a6-4367-80c5-a2d5e73b6652', '+33781452688', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QXPQXC
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:10', '2025-12-13 10:37:26.30725', 'SMfea72d2a73ea084c506cac5c41364d17', NULL),
	('668d34f5-c678-4e68-8e00-b400652c8859', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/REKRKS
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:07', '2025-12-13 10:37:27.650679', 'SM01dc2a0a09586b4606547b78039429de', NULL),
	('4f359a33-8492-4823-b751-874de25aefbf', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MRQWRJ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:00', '2025-12-13 10:37:14.644136', 'SMeaaaf92bdf2b9fc6aa0b5b5bc4beec20', NULL),
	('1559fac7-23ae-43a7-bef1-00c0a96d32f8', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/KCSIBT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:56', '2025-12-13 10:37:14.94774', 'SM0ea91655cb77f2bd93f6c05d4092bcd8', NULL),
	('80561c61-55dc-4b04-a863-596856ac055e', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UUBOCM
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:08', '2025-12-13 10:37:25.982258', 'SM1aa96c026070a39d2958ab0b73563b7b', NULL),
	('bedc3f0a-4e04-49b2-a551-a00eb1b89950', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EZVKFA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:11', '2025-12-13 10:37:29.234372', 'SM53c70cf3a0c14f180f977e43b1565d73', NULL),
	('cab05a13-da8d-4519-b78d-44743b57514b', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XBOSOQ
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:36:49', '2025-12-14 08:17:21.431639', 'SM834f3e9d80e5f6cd7789f6b04d8fc55c', NULL),
	('bdd12ad0-2f97-4b44-bb1d-6ffc9dd5b4f3', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DUWEEU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:12', '2025-12-14 08:19:29.344596', 'SMf39e72648752d84c3701983e064907a3', NULL),
	('b5ab0326-5138-449f-8ab4-8207e14080a6', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HHZFLT
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:05', '2025-12-13 10:37:23.164364', 'SM1f5d67b85b6aa2e16b4a8683aea81248', NULL),
	('631b48bb-6af6-4c64-950f-dea7f8aea59a', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YSIJAA
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:12', '2025-12-14 08:19:38.627316', 'SMb05973f072ff790c0e4e3ba8159fd937', NULL),
	('68880ace-5e00-43ee-a39f-ed77d03320dd', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EUUGMM
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:13', '2025-12-13 10:37:25.458305', 'SM2881aa7d492f797217b354ca6b9e4544', NULL),
	('91c38300-bcf8-4495-b402-f0bd3dc321fc', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/WHTVWF
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:10', '2025-12-13 10:37:28.385984', 'SM5977d490edcb49aec11fc27cb1864bdc', NULL),
	('a6aae981-436d-4784-8a11-aa1f67dd8b09', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/OXWNGR
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 10:37:11', '2025-12-13 10:37:32.42694', 'SM4e967a0dd644d3d9ca16194ded26a52f', NULL),
	('949ef5fc-a1fd-4325-af3b-add7c870fd27', '827fbb3f-b98c-49a2-b9a2-0316d08b07a5', '+33623331594', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SNTZWE
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-13 21:38:41', '2025-12-14 00:43:43.749609', 'SM903d93ed621c69afd0459d723e26f2a7', NULL),
	('e025f590-b93f-4cc9-ac30-278a78fa9d7c', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MKLHKU
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 4, '2025-12-13 10:37:11', '2025-12-14 08:19:27.389439', 'SM5c4c012ddd393970e722bc9860735d66', NULL),
	('007fa3b5-f238-4255-b57f-ba19820b45c3', 'e556d632-a2b9-4de1-be35-f813c522e1e4', '+33631174335', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HQHJON
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 8, '2025-12-13 10:37:12', '2025-12-16 10:37:23.370982', 'SM79e585e49af9e8469bcae2edb314f3d4', 'Erreur de type 30008 : null'),
	('2a69b7c3-5acf-4fca-9a06-fe8e9c9e8254', 'e1b1b0ca-dc2d-458e-a592-23b893f74d09', '+33623182464', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire.
Merci de valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/REINRD
Tu pourras ensuite t''inscrire à la soirée des anciens le samedi 10 janvier 2026.
Si erreur, merci de l''indiquer en réponse; pour ne plus etre contacté, réponds STOP.', 5, '2025-12-14 12:51:44', '2025-12-14 12:51:53.944762', 'SMb03df1f279043845d29bb661960831de', NULL),
	('502a1ebf-4ab0-43a0-adcf-75f93f2d8feb', '27993ea4-ccad-469d-9e53-5f479a6f036f', '+33684354559', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/KOHUFC    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:49', '2025-12-20 16:02:05.824019', 'SM4185591ce43387da7762653aa3a6f9a1', NULL),
	('b710218a-7a20-4562-a12d-d65b75dc5908', 'd2db5300-7888-4d3e-9a2c-9c1e20373c50', '+33661574851', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QHQKJZ    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:49', '2025-12-20 16:02:06.84423', 'SM8268c61e97f58350ffdf3e57a6351713', NULL),
	('8ed8ca40-8f57-4485-b3da-0b8309420d5f', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/NVMXJT    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:48', '2025-12-20 16:02:06.428412', 'SM1ade62d6ef6c59338ba2692923c47b89', NULL),
	('18808cae-aa17-4ba8-8405-502108a4de37', '4b484c05-af0f-4c94-a259-e214b49edf23', '+33618146084', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BXGFCM    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:48', '2025-12-20 16:02:07.339878', 'SM72f31e0907bd26f3c60346a3b8039534', NULL),
	('ba918060-7691-47a5-9dfd-895f6ab68232', 'b185044e-bd20-4a55-8797-c56e26ae8b55', '+33650422408', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/TJBJIT    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:51', '2025-12-20 16:02:08.727032', 'SMfe91b813848b63e846583b6e9446b5e8', NULL),
	('14e97eba-5185-43bd-bfcd-887e1ea48b2e', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ALUPUJ    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:50', '2025-12-20 16:02:09.879816', 'SMef371b7279f7bc4c0b0ecf4c8b98bcd9', NULL),
	('1cbf1946-0b96-4d22-a8b1-454897f7a40d', '0209207d-26cb-4278-823d-c674ce7bea10', '+33677557348', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/JCKJVG    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:51', '2025-12-20 16:02:08.491323', 'SM36142c42ccf5fb91e036815c2229d904', NULL),
	('37429c57-8007-4297-ba0d-df7c98ae90ba', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XMPTWE    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:50', '2025-12-20 16:02:12.072105', 'SMb0cff7f8d55ab416b9aea6e02461cbd6', NULL),
	('5b9d8633-f79f-4a19-877a-28d93ececca9', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YFJQGN    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:50', '2025-12-20 16:02:12.858435', 'SMea5680ab25e4ce8179d9bdf7b3ef5916', NULL),
	('94707a26-0e5e-47fe-aec3-3c350ec0cad4', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YQAEVX    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:51', '2025-12-20 16:02:14.974999', 'SMf0fd0198934e588b0bf7ce1857620473', NULL),
	('17b5c357-8f37-4276-aa10-a9ee5ff7a406', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BBITSP    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:52', '2025-12-20 16:02:17.792778', 'SMb4a65b1bcd9b9847dc34437871b1bda6', NULL),
	('e8e45b2d-22d8-4c22-a185-07649af31d15', 'b03d5b1c-74cc-4ec8-9dfb-528494803a4d', '+33661892899', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DGFJJB    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:01', '2025-12-26 18:17:01', 'SMdd029a1c65ee509da3e699f52d44db62', NULL),
	('f057d346-9bc2-4d8a-887e-0476fe417617', '07c6873b-8105-45a8-b3b9-3687ee8b291a', '+33689516915', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZXDAQA    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2025-12-20 16:01:48', '2025-12-20 16:02:04.851427', 'SM7ad805184d7e7d77f7e8b57ddcbb81af', NULL),
	('922b4c8e-a3be-4271-a686-f8d779ece1a5', '88a61b77-620e-412d-9cba-14e58872b26c', '+33610612709', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/XMPTWE    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 0, '2025-12-26 18:17:01', '2025-12-26 18:17:01', 'SMa573b90d234dffb86cb0a8896804b98d', NULL),
	('4376b11a-6862-4024-bb25-1317fa2d0ffe', 'f1464f27-ed26-4c1d-8dd3-cb9fb44be6c6', '+33618844228', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ARSROU    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:02', '2025-12-26 18:17:02', 'SM8e2c77a8f7be8fa3639b403bd8940356', NULL),
	('18623990-44a9-45d9-b158-09181e6033b6', 'f2ece8fd-c279-4af5-8771-90fa9375a3b5', '+33632407584', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZZGKPQ    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:02', '2025-12-26 18:17:02', 'SM8af834bed351009e096397f2ca906ca8', NULL),
	('5d618e79-893d-4631-be36-ddab283d65c0', '47b5f9ca-ca9a-440b-8416-5509730c4385', '+33617684016', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PMPNGC    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:02', '2025-12-26 18:17:02', 'SM19f6bb752535665acd759c8bd00268d2', NULL),
	('d929d16e-6518-404c-a5b3-b52482fefe05', 'b8dfe634-d5b9-43c1-ae7a-1bda4888f63a', '+33662813036', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MRQWRJ    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:03', '2025-12-26 18:17:03', 'SM4099d851264467994a0adcd0f3c4a382', NULL),
	('ca888633-a026-40c2-90f4-cb8a8a5081ef', '16271680-19a8-4184-a754-337364221875', '+33673426632', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/AGLEEW    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:03', '2025-12-26 18:17:03', 'SMe7d416c6399eda37ac250d7c3b4ac63c', NULL),
	('d10b42d8-0ff4-47a8-940a-6a4c6f57d9fe', '70a55248-c199-4274-9ec6-2806f142979a', '+33755279646', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ISRUOW    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:03', '2025-12-26 18:17:03', 'SMf0eb68cc8f5439b490171c21b36edc11', NULL),
	('e5d44664-2f3c-4510-b499-e39e834107e3', 'b3d7410b-8cd4-4b6f-9009-a53d9c5cb341', '+33637110912', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MKLHKU    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:04', '2025-12-26 18:17:04', 'SMff0e6a50e538bc505e4c62dd26b0eb26', NULL),
	('3be0d7c2-a76b-47e0-9d08-7418db3e5209', 'cdfe9872-39f7-4b2b-8d6c-28105af47b0d', '+33626216291', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/WEQLWV    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:04', '2025-12-26 18:17:04', 'SM2194a6f8fe7258a66642e2276d49c391', NULL),
	('ec75487a-e2ae-49ed-a1b1-917eb44fc0e9', 'd75f7556-001c-4e7f-a5f9-90ac61db8e9e', '+33662382730', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SFGIUQ    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:04', '2025-12-26 18:17:04', 'SM834475a150bf85c2bc45aff571934e84', NULL),
	('3994e55a-d364-45ee-a8d5-97ce14d4a3c1', '20a4dd11-e5f3-49eb-b316-752601087c89', '+33630117869', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DUWEEU    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:05', '2025-12-26 18:17:05', 'SMa3506cd960b848a588259179448a7e0d', NULL),
	('16deb316-97bb-4ce1-a979-360a0787b040', '1777b7b4-c3af-480e-bcbe-496d5b4ef1e0', '+33677916982', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/AVYHQD    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:05', '2025-12-26 18:17:05', 'SM3dbf300d3ad77947b78dce32050775d1', NULL),
	('9d34ffb8-c497-4eec-90af-aa3e92d8ce43', '769f4031-9580-48cb-a31d-130276cc82ba', '+33611169698', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/JBHLNG    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:05', '2025-12-26 18:17:05', 'SM40e408feef8ee6a4a144b89c58de7449', NULL),
	('75df6844-9d95-4001-a5e5-bdcabf645c25', '375ec00e-5499-4018-ab66-88a095c7b0fd', '+33683713610', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HFHGBK    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:06', '2025-12-26 18:17:06', 'SMa8aaf1cfd1d359d584f7d1fa278ecaf1', NULL),
	('35ec7230-5723-4a5a-8830-6c8f04c56153', '37ed2a8e-0aad-4908-9abe-c46bb19c4153', '+33604650942', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/IDNVJG    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:06', '2025-12-26 18:17:32.266347', 'SM2236b9ce9274f7df6dccaa1c5f34a12a', NULL),
	('00803006-3427-4230-8fa2-5fd8bf45d6b6', '7201762a-7198-4814-a5d0-389915ff3aae', '+33783265261', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/YQAEVX    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 0, '2025-12-26 18:17:07', '2025-12-26 18:17:07', 'SMd65bf944c6db789d6330b4b9832f0d07', NULL),
	('527faf9b-3e27-4529-bd27-2328ceb6973b', '52c217bc-54c2-421b-bb66-398feb93a958', '+33648176732', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HYISTJ    Merci pour ton aide et peut-être à bientôt !.', 0, '2025-12-26 18:17:08', '2025-12-26 18:17:08', 'SM56da4bc3f38b1cbdc2c523156ba25763', NULL),
	('510cc482-ddd9-48ff-ba19-05be793b4825', '528a0d26-5637-4f6f-94fc-1afcecdaf115', '+33676442573', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YSIJAA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:08', '2025-12-26 18:17:29.098751', 'SMc0d02b67faed734fc402b39cf8c3d7f6', NULL),
	('f1d18c35-03cb-4968-8cf4-80483b9416f1', 'f3d3c1b5-97ab-4e00-9897-8d6fbfbb8c2e', '+33688968541', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RTUMAC    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:07', '2025-12-26 18:17:29.268271', 'SMabceb9897a7247af22c80a5cfe0f4c9e', NULL),
	('187e2663-c7c8-4cd6-993c-36a857cb940b', '9fddca8e-be3c-48e7-a0bb-025359db6063', '+33676604921', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MNYYLJ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:08', '2025-12-26 18:17:29.763757', 'SM87c2031a399d5fc65ec535eed46e1560', NULL),
	('3fc661d5-f858-4164-9d2d-e3cfba3c2d87', '2ba82819-525c-4a00-b3ee-ede5331d987e', '+33685093793', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/NWAZTK    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:11', '2025-12-26 18:17:29.867294', 'SMc877038f2b2a7deb2854405463b73daa', NULL),
	('228c32c6-aea8-4c9c-b1fd-67f88dfe787e', 'd4c86b2f-0fb4-4176-b031-29ef3c4f2f43', '+33698637607', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UVICCS    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:11', '2025-12-26 18:17:31.152209', 'SMd14b1971941423ed54b81d839d2b5efc', NULL),
	('ae17783e-f462-4a41-9cfd-8054ca7ab2eb', '5f1b11b3-2599-41eb-8ec8-75584d9e97b5', '+33636177610', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YCXMMI    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:09', '2025-12-26 18:17:31.663092', 'SM8f473906f8e46dd3cf94a20a9985bf55', NULL),
	('ee6d5bd7-43a6-4853-8c3a-4620bf97d8b0', '491f0284-7cd7-4994-9a7c-fe6c5a79dd26', '+33678641933', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/KFKSEU    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:09', '2025-12-26 18:17:33.502711', 'SMeb0108117b832095e170a4236f54eaaf', NULL),
	('3495e3cb-efe0-475d-8a3c-cbd11cfa2732', '711b0ffe-b8c6-4df7-acab-bdcb3afe5cc7', '+33643042588', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/JKIWXV    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:06', '2025-12-26 18:17:34.66519', 'SMef2bb261ac0a4e9251625c4acfa9778f', NULL),
	('2f737c19-b81f-4900-93fb-05076d6c54cd', '19b7c259-94f6-4651-809d-d308b4350f0e', '+33665961948', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YKSLWR    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:12', '2025-12-26 18:17:35.32043', 'SM39d3dddd5525c7f73bde43ff0f024f8b', NULL),
	('21725baa-95a0-4cd9-a6b4-f8174baec0e8', 'bb30e395-fcce-47eb-9290-2672151e1a4b', '+33699349915', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UHSKQA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:10', '2025-12-26 18:17:36.553313', 'SMa4247aa4d8c536abc008747d6f18fee1', NULL),
	('375d95d7-8ff3-4058-925f-ef96a2a5fcee', 'd10d34ca-889c-4390-b31d-c7b320b8313f', '+33678271384', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SETJQA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:10', '2025-12-26 18:17:38.192668', 'SMa621cdbfcb08b23413b9b5f392e5b21f', NULL),
	('814252e0-7507-4f4b-a626-e51f805cbdef', '97293d6f-1c4c-41c6-8612-fe3982fc5d91', '+33652568550', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/SRMBHN    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:10', '2025-12-26 18:17:41.295017', 'SMf8fa5b6d43fc591fc7cdf6efef934234', NULL),
	('bf9aedad-b18e-43e4-b2be-e9d927518159', '8b6d633f-1ff3-4b19-bb40-27a69834346f', '+33620265215', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZHMDAA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:14', '2025-12-26 18:17:46.0882', 'SMe4871ecbb285a437e4025606d684014b', NULL),
	('f14eee4e-2865-483f-8814-344192b0e8da', '2b119672-1da0-459d-80aa-93cb1f43f0d3', '+33787788914', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/GCSGGU    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:14', '2025-12-26 18:17:47.778316', 'SM4cb301db22ce08ea885aff72a28ff6b6', NULL),
	('9102d96f-23c4-4b71-9257-517b9cc040fd', '0b3a5924-4c76-4776-8f1b-3704c83ef53e', '+33650009161', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HIFQYY    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:17', '2025-12-26 18:17:51.3695', 'SM203105752cb41cca55ce993cd3e3cfdb', NULL),
	('fc889a7c-4160-4f5c-a6f5-2944f82efdce', 'ef507372-33fb-4b2c-80d3-d884aa46177d', '+33642436503', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/WHTVWF    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:15', '2025-12-26 18:17:32.839251', 'SMf630a8afe6c426d6895381b580c97f1f', NULL),
	('2484973d-2210-440a-954a-6d84a4b1fd36', 'ac779409-6fda-4707-a245-fd5ff88202c4', '+33649281834', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RKPRCJ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:17', '2025-12-26 18:17:48.742123', 'SM5527393359c2badfa6d19611d5b2ad05', NULL),
	('24728a41-552a-4465-84c2-157855270af1', 'ae693e20-705e-4b03-b166-d4b34c2e4418', '+33761538893', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UUBOCM    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:17', '2025-12-26 18:17:50.463104', 'SM138307dc977f1a4117bc53d7a621c7b5', NULL),
	('0609a6db-d6af-4d31-9f13-4bbf388007ec', '81f643d7-7f27-41f1-94ac-7791cd52980e', '+33645196472', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PTKJRT    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:15', '2025-12-26 18:17:34.257479', 'SM39fdf1278fd6a48258af7e0569d7fdc9', NULL),
	('9aa9d1c1-bdfa-498f-826a-711339142cf2', '2fe6c647-c716-4154-a571-28753717d427', '+33631865534', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZYQXSA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:16', '2025-12-26 18:17:36.493539', 'SM40563d9785024827531ed7f250e9605d', NULL),
	('3cb7dbb4-22ff-4982-af18-958d748e1184', '1fb52d42-a949-435d-a3f4-7e3e6e06c8c2', '+33782547924', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/REKRKS    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:16', '2025-12-26 18:17:38.960585', 'SM682ea7d596134acb0426508d3f7fa7f5', NULL),
	('0ceaf6f0-4cd9-4183-bed4-aceb420841ee', '79e356bb-3520-4058-857d-9605a1580986', '+33610076463', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MNIFMY    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:13', '2025-12-26 18:17:39.468183', 'SM91b8550769ab751556886a6d2bac3291', NULL),
	('3e8ec79c-f20f-406d-b789-cde6500abbfd', '5e9c8545-96d0-4a92-9079-70a861999f35', '+33611443117', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QMQSHO    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:12', '2025-12-26 18:17:41.440949', 'SM854953f826eba462ca29f1fb31460e4b', NULL),
	('e179b695-6844-406b-8b49-bbfd49f3d0b0', 'fee443a9-634b-497a-8d0b-ffc6e835307d', '+33623367833', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/KCSIBT    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:13', '2025-12-26 18:17:42.298892', 'SMa42880721c560a0917f13c902956fc0b', NULL),
	('97554cee-ec2d-47f4-9916-2dc63f9a8f6e', 'd1d093b1-9017-41eb-8418-5a59a6bcc01e', '+33669143595', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RNSXVQ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:13', '2025-12-26 18:17:43.367548', 'SMed6845c6f13ac5a5210eaf527d794ce5', NULL),
	('efe6a92e-7f95-421d-be73-37668fe00d51', '43f2ab3f-7636-4f33-a7ac-bbe794680310', '+33613880756', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/IDYLAZ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:14', '2025-12-26 18:17:45.168844', 'SM1d2685ce119d2fe8a821347d62241637', NULL),
	('d6e7f15b-9f88-4590-a7bb-23eff225f167', '196319d4-61d8-4e5d-afc6-87a510146d50', '+33683923380', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/FCCWTW    Merci pour ton aide et peut-être à bientôt !.', 7, '2025-12-26 18:17:19.602043', NULL, NULL, 'Erreur lors de l''envoi du SMS: Attempt to send to unsubscribed recipient'),
	('492a3c51-e4e9-484f-b8a4-5931b152dd1d', 'ecc78dae-6e27-42a3-a58b-302ecc8599a0', '+33680622155', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BGZUUX    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:18', '2025-12-28 19:27:41.346511', 'SM6fb652778ea57fdbf31c7293c0b313c3', NULL),
	('c7d6b4b7-40b0-47c2-a9c4-1987d8ce2c36', '769852c8-aece-4eec-9286-cf0ef65f3d75', '+33661861732', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RYYYBN    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:18', '2025-12-26 18:17:54.256413', 'SMe74d89e4c2274694b26c004ce9eb0a0f', NULL),
	('9a75551e-df5a-4dad-9269-849f1a92cd21', '4f907f34-d778-4bed-a54c-b56446702069', '+33760808161', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DKMGFS    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:22', '2025-12-26 18:17:46.622774', 'SMc6e806ae23a96d3c28f0eff3232bda29', NULL),
	('ca212a03-6fae-4116-838b-184b9e590a21', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/BBITSP    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 5, '2025-12-26 18:17:21', '2025-12-26 18:17:37.600077', 'SM331de3c8bb8c0007ad80361c233e0e20', NULL),
	('fdebabd0-a3e2-4538-80a8-99704994aa87', 'c421cc06-f20c-4fc6-8b1b-17650b38c9c5', '+33749177447', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/HHZFLT    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:22', '2025-12-26 18:17:56.011793', 'SM972d348e92ebee213400b5748a3bd386', NULL),
	('a7c91116-3489-44da-99a6-053ca341a52d', 'f97003e8-e6b5-4b3e-b92e-55a7f6e967fe', '+33606801230', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UQCUWA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:21', '2025-12-26 18:17:55.329579', 'SM9f6a9e3fa07d2406f449cbe2633e15ca', NULL),
	('248faefc-f91c-4890-873a-218aebf91922', '9e508539-e73c-4654-b219-9e3401fa82c5', '+33608153036', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PNXYXF    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:18', '2025-12-26 18:17:40.402607', 'SM5a6ec08da7cd4095839ec23e5164415e', NULL),
	('cf1b424d-b08f-4b15-b726-a97041efdc04', '6d2cbb9e-f757-4fc5-ba51-cf48e92c3699', '+33787116471', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QYPPEQ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:19', '2025-12-26 18:17:57.254139', 'SM327af105ee3003308170b987f3664734', NULL),
	('2bf8769d-d2c1-4528-81bf-31a71f2a8970', 'eac7028e-f054-46c2-82d2-d9d656f1692b', '+33640646375', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZQFWHQ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:20', '2025-12-26 18:18:02.404041', 'SMd78066cbbb95da229de680c121ff8071', NULL),
	('2d8a836b-8a65-4c12-9491-b304e49d3a51', '979e0719-1ea0-4c38-a00a-7423415a076e', '+33622471106', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UALFFU    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:20', '2025-12-26 18:17:42.131174', 'SM72dd2e2d3c0165162dd7f7864836c950', NULL),
	('21c54f8a-ec1b-455c-a181-02c7dfe2d9d9', '69a77fc4-eeee-40cd-ad24-f80355990a6a', '+33676989058', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ZBYMEL    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:20', '2025-12-26 18:18:03.268943', 'SMcd9e475f85f4840174255ac975599992', NULL),
	('9a07d338-32a8-48ce-a197-268f6d1b937b', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/ARFSDN    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 5, '2025-12-26 18:17:19', '2025-12-26 18:17:46.115831', 'SM38f276ef16453ead378449b51a887a34', NULL),
	('bb64a02c-7cb7-453d-b89b-b89fe4373589', '658117c8-99f5-4390-8949-f209b4c28482', '+33644249796', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EUUGMM    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:17', '2025-12-26 18:17:50.093087', 'SM5cc3f8730b89bf1268248745e70304a3', NULL),
	('78711fdb-ec49-433a-a127-9a5508222def', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/YFJQGN    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 5, '2025-12-26 18:17:25', '2025-12-26 18:17:44.746419', 'SM194ae6bf5ea674db3b793a8aeb9ac6eb', NULL),
	('a69d838a-5b9c-453b-a56b-1ec67d90c24d', 'd8d12de2-0744-4f2e-b54b-c6a703eaee43', '+33667924388', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EZVKFA    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:24', '2025-12-26 18:18:10.146152', 'SMcbb4cef7bb69850abd07576a11eb347b', NULL),
	('b297f74b-05f3-47f1-b067-1071a6a92427', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/ALUPUJ    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 5, '2025-12-26 18:17:25', '2025-12-26 18:17:46.919995', 'SMd067a45a0f7fa305f071eca863e1da78', NULL),
	('a9b33ce4-ec12-40a4-a0da-c9b1ff22104f', '99ee53bb-97cd-4ff2-90f9-c6e32792295b', '+33607872953', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XBHJUY    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:24', '2025-12-26 18:17:48.992905', 'SM6e881437a86180fd3a736cd1f010e903', NULL),
	('f403d330-c3ac-4446-949a-f28b25712131', 'edec597f-7c61-4c46-8455-24192a607e50', '+33680518716', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RUVMKD    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:26', '2025-12-26 18:18:12.866705', 'SM5d3187180f243e0449171a7861cbcc09', NULL),
	('0fc62f8a-fdff-41d8-b51e-1ec4265b3bd7', 'd7db3ca0-5de1-4dc5-b1c6-cbc0b7849281', '+33661527093', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MQCXCZ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:25', '2025-12-26 18:17:52.263528', 'SMe135429a5cccb5a3b84b80ab1ed44b09', NULL),
	('e7a76ce4-0e7a-419b-9dd1-bc74aad82354', '6e77f176-7762-4993-970f-6715c66362b6', '+33777953119', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/DNFRFO    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:26', '2025-12-26 18:18:14.789216', 'SMe78cef1ab15a8747ca25cf43ddd1186a', NULL),
	('654fb368-85e0-4f19-979f-0ccab4b20bb2', '1f1eae4c-2c39-420c-98c3-cc33ed0c481a', '+33689453454', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PFATCY    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:15', '2025-12-26 18:17:44.528614', 'SMba3c191c2b460ac143a34274b9ea2c47', NULL),
	('23a21bf1-e39a-4f1e-904d-9b34e8fef2f0', '34f4e53c-8f9d-4a4d-a07c-457d66d90cef', '+33663216526', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EJLAIF    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:12', '2025-12-26 18:17:44.637269', 'SMf41c8dead9d6b81b963caf0828a2b63d', NULL),
	('d80fddbe-8aaf-412a-94e0-6c525918a478', 'c87726db-55ae-4a63-8cfe-81801092d087', '+33607343250', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ELHDPY    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:23', '2025-12-26 18:17:44.728143', 'SM07cc056cb0134054e905a9decd49ebf3', NULL),
	('d5cf0623-8706-4864-8492-bd60b23ed921', 'af5f3625-3325-4eb2-ba62-65c1f48c378b', '+33683849305', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/MRCNMG    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:27', '2025-12-26 18:17:52.183253', 'SMaddcaf4d1e8fbf83a244e7ee6e63102f', NULL),
	('cceefd0e-2c59-4ee1-8cfd-5b9df4a11cbd', '3c7c2be8-aba6-40a7-ac0f-ff985135ea5b', '+33684966107', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/PTVDQP    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:22', '2025-12-26 18:17:53.97288', 'SM4e42491a205d94eb86c8edf048912a32', NULL),
	('2e0caa3a-ab5d-460e-8e08-6e8de7a04ce0', 'c0c8e3cc-f36b-4f46-8767-3586065ecbd5', '+33689211383', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/RVLJBP    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:27', '2025-12-26 18:17:57.358396', 'SM4cf87e432323d2fbac4abfb755ada36a', NULL),
	('df7e94d3-dbd4-47de-961f-23b372ced3ed', '2c2e4e41-9026-44b3-a096-5a3721de91f1', '+33608045070', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/LKZJQB    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:23', '2025-12-26 18:18:06.481809', 'SMb7759728a01bcdd4c7f3e3ebc34e30ab', NULL),
	('3a7aeb46-63a0-468e-b60e-96317dd5751a', '259ae5aa-47c1-4a7c-80c8-c2b07e0ff9da', '+33609836382', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/OXWNGR    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:06', '2025-12-26 18:17:29.468203', 'SM6a57ebe664fb5af9ea5a9e670ed74292', NULL),
	('09ff1152-005f-41bd-bad7-4525c9a33e87', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', 'Salut, c''est Sébastien. J''ai besoin d''un petit coup de main pour finaliser l''annuaire des anciens de Hoenheim.    Peux-tu prendre 10 secondes pour confirmer tes infos ? https://alumni.hoenheimsports.fr/former-teammates/validate/NVMXJT    Ta validation m''aide énormément pour préparer la soirée et retrouver tout le monde. Merci d''avance ! STOP pour stopper.', 5, '2025-12-26 18:17:21', '2025-12-26 18:17:40.076368', 'SM00324ea5d3dd1d11d09acf236cd218bf', NULL),
	('839c8ef6-4ce7-417c-a6e2-76e5e17d8c5d', 'c2955784-50db-4ff2-8d59-f8b5c6bc248f', '+33684725466', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XBOSOQ    Merci pour ton aide et peut-être à bientôt !.', 5, '2025-12-26 18:17:24', '2025-12-26 18:17:46.849381', 'SMcac959dcef029cd9be22c55f95e6beaf', NULL),
	('62fddb92-cd45-42ff-9666-750869da1f46', 'fe07d772-f789-44e5-88e6-f424d9dce984', '+33616761014', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ARFSDN    Merci pour ton aide et peut-être à bientôt !.', 5, '2026-01-01 11:17:40', '2026-01-01 11:17:57.366395', 'SM61e999ad1b9f0a99fdadb792134a79cf', NULL),
	('1e9371d3-b696-48fa-a539-42f7e5200cf4', 'c067b1d2-1523-46ab-b67b-eec7ea218603', '+33769792266', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BBITSP    Merci pour ton aide et peut-être à bientôt !.', 5, '2026-01-01 11:17:40', '2026-01-01 11:17:57.59328', 'SM834a6d32c476192cf39296d0f4bcd9d8', NULL),
	('5bd88a4b-8468-467f-a1b9-47d09ac515c0', '5b94d080-af97-41fe-a0b9-54b462a0aebc', '+33647430956', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/NVMXJT    Merci pour ton aide et peut-être à bientôt !.', 5, '2026-01-01 11:17:41', '2026-01-01 11:17:58.670859', 'SM02572edd2a5834a1e33fb7f111ff6257', NULL),
	('6d7cd75e-cd11-413d-a048-4007c88d135e', 'fe662c82-532b-4d52-8de5-ba4effa67703', '+33615182224', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/ALUPUJ    Merci pour ton aide et peut-être à bientôt !.', 5, '2026-01-01 11:17:41', '2026-01-01 11:18:04.555571', 'SM13994d74a25b1eabc367bd65c4bd68a3', NULL),
	('438ab3a1-b461-4199-a5c3-e4ad252720de', '5ec6fe34-c77e-4c34-86f4-5bdd380661b5', '+33635714555', 'Hello, c''est Sébastien. Ceci est mon dernier message pour l''annuaire de la SM1/SF1.    J''aimerais vraiment que tu y figures, et ensuite, si tu veux, tu pourras t''inscrire à la soiree du 10/01/26     Dernière chance pour valider ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/YFJQGN    Merci pour ton aide et peut-être à bientôt !.', 5, '2026-01-01 11:17:41', '2026-01-01 13:06:41.921063', 'SM20a2f0c05880c98eadb3b0e959b7d67b', NULL),
	('b303df1f-d9ea-4dd3-9d73-9220f41e59e4', 'ee5e141a-341b-4c9e-a82c-e500bbcae527', '+33624630236', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/UUVVON    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-03 12:38:32', '2026-01-03 12:38:48.018062', 'SM6854db3dec870c593f6a688d10992fb2', NULL),
	('a153a66d-4f7b-44af-94a7-0dc1e4b79224', '91af7307-0c46-4276-8349-de60962d0017', '+33649874965', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/XPMMXQ    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-03 06:04:44', '2026-01-03 06:04:59.877656', 'SMbc4751e7056d18b5195df7be2fff86f3', NULL),
	('06371d11-0557-49a1-8d4d-d8ae7496be40', '8bc693cd-3537-4dcd-8717-39b24bf56086', '+33685218647', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/EIYOVB    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-03 12:38:43', '2026-01-03 12:38:57.949244', 'SM99a41dac46ea13ce72ed7538c5385fe7', NULL),
	('92791ca6-a867-4f70-9833-08a4e1ba8d9a', 'd542946e-ddbe-440f-b74c-c608f2e6593d', '+33628233540', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QCWGFY    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-03 18:37:56', '2026-01-03 18:38:15.978253', 'SMe486361d17b40ab2ec09781fb24b4ee5', NULL),
	('28c66eb5-6d13-455a-9dba-b4ba5f87aab7', '36820e75-1d05-4eeb-aa1f-9ebb5394fab9', '+33611432510', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/CXVMYD    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-06 19:54:09', '2026-01-06 19:54:28.695354', 'SM8c0e42667bd2f52130ee8fd2bf943a07', NULL),
	('bdf8f354-c77a-489e-8c90-af455787eb7b', '9405013c-4909-428d-aebe-35686e7d857f', '+33783799874', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/BPXFXL    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-06 20:04:44', '2026-01-06 20:05:01.829275', 'SM9c77688be2d3e86dee11def6490b07ba', NULL),
	('c8e5ee5a-0c23-404e-b254-16e4866f22fc', 'db1ecd95-b0bf-4581-99b0-955622143a74', '+33645079205', 'Bonjour, c''est Sébastien Burckhardt (+33638937416). Un ancien de la SM1/SF1 de Hoenheim t''a ajouté à l''annuaire du club.    Peux-tu m''aider à le compléter en validant ton contact ici : https://alumni.hoenheimsports.fr/former-teammates/validate/QMLXOH    Tu pourras ensuite t''inscrire à la soirée des anciens du 10/01/26. Merci ! Réponds STOP pour ne plus être contacté.', 5, '2026-01-06 21:15:21', '2026-01-06 21:15:40.36171', 'SMdb0823f582b178449edc5b3b7824b234', NULL);


--
-- TOC entry 3483 (class 0 OID 0)
-- Dependencies: 229
-- Name: participant_seq; Type: SEQUENCE SET; Schema: public; Owner: app_prod_user
--

SELECT pg_catalog.setval('public.participant_seq', 601, true);


-- Completed on 2026-01-08 17:30:42 UTC

--
-- PostgreSQL database dump complete
--



