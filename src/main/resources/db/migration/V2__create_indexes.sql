CREATE INDEX idx_stadium_name ON stadium(name);

CREATE INDEX idx_club_name ON club(name);
CREATE INDEX idx_club_stadium_id ON club(stadium_id);

CREATE INDEX idx_player_name ON player(name);
CREATE INDEX idx_player_club_id ON player(club_id);
