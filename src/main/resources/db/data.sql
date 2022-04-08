INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (1, 'testA', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Kim', 'ROLE_ADMIN', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (2, 'testB', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Lee', 'ROLE_ADMIN', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (3, 'testC', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Park', 'ROLE_ADMIN', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (4, 'customerA', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Choi', 'ROLE_USER', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (5, 'customerB', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Kang', 'ROLE_USER', now());
INSERT INTO account (`id`, `user_id`, `password`, `name`, `role`, `created_at`) VALUES (6, 'customerC', '{bcrypt}$2a$10$Czj71JwN8KCX7qN3e4114eirwFonEEX/i6bkclp5js09rXMPuaj/O', 'Yang', 'ROLE_USER', now());

INSERT INTO voc (`id`, `title`, `content`, `voc_status`, `created_at`, `user_id`, `admin_id`) VALUES (1, '질문있어요', '이건 왜 안되는걸까요?', 'COMPLETE', now(), 4, 1);
INSERT INTO voc (`id`, `title`, `content`, `voc_status`, `created_at`, `user_id`) VALUES (2, 'I have a Question', 'Why?', 'NO_MANAGER', now(), 5);
INSERT INTO voc (`id`, `title`, `content`, `voc_status`, `created_at`, `user_id`) VALUES (3, '이건 왜 이럴까요', '저에게 왜 이러시는거죠?', 'NO_MANAGER', now(), 6);

INSERT INTO reply (`id`, `title`, `content`, `user_id`, `voc_id`, `created_at`) VALUES (1, '답변입니다.', '이렇게 이렇게 하면 될 것 같습니다.', 1, 1, now());
