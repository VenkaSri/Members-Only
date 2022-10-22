INSERT INTO pet (userName, password)
VALUES
('Grey Wind', '$2a$10$lJ9SDL6MvEbtOMsMEpm8sOYhwpSq9wBtlmOuecqacBViNtWj4/l0.'),
('Drogon', '$2a$10$DB4nrcnPNlMdRFW3UhS6N.5hWiP3M.YcO1X646J0iqJcFRifSmQy6'),
('Nymeria', '$2a$10$q2YaR/rF8lRvg/QhCVeEQ..ByN43UQykvf2vpt/bvXhgxxw3iyThC'),
('Rhaegal', '$2a$10$oK5QlWnJRYVMtc1StdvFressaf6rFrpnpE2F3L3qmF0UK8frmWIvS'),
('Viserion', '$2a$10$K0bYNhhCTa4y3VI7NVuhPOD5Bqf1laflIfko9lSfHObGFKkTch30O'),
('Ghost', '$2a$10$sLqIrmABAG7vZJl2JsTj.OqiVS.Cr4C7B6AwhFKZS.w0cTMqBqYXC');

--3z_&9P!--

INSERT INTO roles (roleName)
VALUES
('ROLE_CAT'),('ROLE_DOG');

INSERT INTO PetRoles (petID, roleID)
VALUES
(1,2),
(2,1),
(3,2),
(4,1),
(5,1),
(6,2);
