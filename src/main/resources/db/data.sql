INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (1, 'testA', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Kim', 'ROLE_USER', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (2, 'testB', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Lee', 'ROLE_USER', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (3, 'testC', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Park', 'ROLE_USER', now());

INSERT INTO voc (`id`, `customer_id`, `title`, `content`, `voc_status`, `created_at`) VALUES (1, 'customerA', '질문있어요', '이건 왜 안되는걸까요?', 'COMPLETE', now());
INSERT INTO voc (`id`, `customer_id`, `title`, `content`, `voc_status`, `created_at`) VALUES (2, 'customerB', 'I have a Question', 'Why?', 'NO_MANAGER', now());
INSERT INTO voc (`id`, `customer_id`, `title`, `content`, `voc_status`, `created_at`) VALUES (3, 'customerC', '이건 왜 이럴까요', '저에게 왜 이러시는거죠?', 'NO_MANAGER', now());

INSERT INTO reply (`id`, `title`, `content`, `user_id`, `voc_id`, `created_at`) VALUES (1, '답변입니다.', '이렇게 이렇게 하면 될 것 같습니다.', 1, 1, now());
