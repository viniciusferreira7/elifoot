-- Flyway already runs in a transaction → NÃO use BEGIN/COMMIT

-- =========================
-- 1. DROP FOREIGN KEYS
-- =========================
ALTER TABLE player DROP CONSTRAINT IF EXISTS fk_player_club;
ALTER TABLE club   DROP CONSTRAINT IF EXISTS fk_club_stadium;

-- =========================
-- 2. CONVERT PRIMARY KEYS
-- =========================
ALTER TABLE stadium
    ALTER COLUMN id TYPE uuid USING id::uuid;

ALTER TABLE club
    ALTER COLUMN id TYPE uuid USING id::uuid;

ALTER TABLE player
    ALTER COLUMN id TYPE uuid USING id::uuid;

-- =========================
-- 3. CONVERT FOREIGN KEYS
-- =========================
ALTER TABLE club
    ALTER COLUMN stadium_id TYPE uuid USING stadium_id::uuid;

ALTER TABLE player
    ALTER COLUMN club_id TYPE uuid USING club_id::uuid;

-- =========================
-- 4. FIX CONSTRAINTS HERDADAS DO V1
-- =========================

-- Remove o UNIQUE indevido em stadium_id (V1 tinha UNIQUE na coluna)
ALTER TABLE club
    DROP CONSTRAINT IF EXISTS club_stadium_id_key;

-- =========================
-- 5. RECREATE FOREIGN KEYS
-- =========================
ALTER TABLE club
    ADD CONSTRAINT fk_club_stadium
    FOREIGN KEY (stadium_id) REFERENCES stadium(id);

ALTER TABLE player
    ADD CONSTRAINT fk_player_club
    FOREIGN KEY (club_id) REFERENCES club(id);