## Phase 1 P1-07 Baseline Artifact Schema and Storage (v1)

Status: Draft (ready for QA + PM review)
Version: 1.0
Last Updated: 2026-10-08
Backlog Item: P1-07
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)
Depends on: [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md), [phase1_p1-02_legacy_environment_bootstrap_runbook_v1.md](phase1_p1-02_legacy_environment_bootstrap_runbook_v1.md)

### Objective
Define a standard structure and naming model for Phase 1 evidence so baseline runs are auditable, comparable, and repeatable.

### Scope
- Baseline build evidence from P1-02 and P1-03.
- Baseline runtime evidence from P1-04 matrix runs.
- Inventory evidence references from P1-05 and P1-06.

### Storage Policy
1. Evidence root for this repository:
- software_development/TestSuite/Logs for legacy runtime-generated log artifacts when present in legacy runtime output.
- .planning/evidence/phase1 for curated evidence package files and metadata.

1. Retention status:
- Provisional: keep all Phase 1 evidence in-repo until retention period is approved by PM and QA.

### Canonical Directory Layout

```text
.planning/
  evidence/
    phase1/
      index/
        phase1_evidence_index.csv
      bootstrap/
        P1-02/
          <RUN_ID>/
            env_snapshot.txt
            ant_targets.txt
            ant_diagnostics.txt
            build_output.txt
            notes.md
      build/
        P1-03/
          <RUN_ID>/
            build_output.txt
            artifact_manifest.txt
            checksums.sha256
            notes.md
      runtime/
        P1-04/
          LMS/
            <RUN_ID>/
              screenshot_start.png
              screenshot_end.png
              summary_log.txt
              notes.md
          SCO/
            <RUN_ID>/
              screenshot_start.png
              screenshot_end.png
              summary_log.txt
              notes.md
          CP/
            <RUN_ID>/
              screenshot_start.png
              screenshot_end.png
              summary_log.txt
              notes.md
          MAN/
            <RUN_ID>/
              screenshot_start.png
              screenshot_end.png
              summary_log.txt
              notes.md
          CHK/
            <RUN_ID>/
              screenshot_start.png
              screenshot_end.png
              summary_log.txt
              notes.md
      inventory/
        P1-05/
          evidence_refs.md
        P1-06/
          evidence_refs.md
```

### Run ID Standard
Use the P1-01 convention for runtime runs:
- P1-04_<GROUP>_<CASEID>_<YYYYMMDD>_<RUNNER>

Add equivalent patterns for build and bootstrap:
- P1-02_BOOT_<YYYYMMDD>_<RUNNER>
- P1-03_BUILD_<YYYYMMDD>_<RUNNER>

### File Naming Rules
1. All filenames use lowercase snake_case except RUN_ID folders.
1. One notes file per run folder named notes.md.
1. One machine-readable metadata file per run folder named metadata.json.
1. Time in metadata uses ISO-8601 UTC format.

### Required metadata.json Fields
```json
{
  "run_id": "P1-04_LMS_BL-LMS-01_20261008_ENERG",
  "phase": "phase1",
  "backlog_item": "P1-04",
  "group": "LMS",
  "case_id": "BL-LMS-01",
  "baseline_class": "B",
  "runner": "energ",
  "timestamp_utc": "2026-10-08T20:00:00Z",
  "workspace_commit": "<git-sha-or-working-tree>",
  "environment": {
    "os": "Windows 11",
    "java_version": "OpenJDK 25+36-LTS",
    "browser": "<name-version>",
    "ant_version": "1.10.18"
  },
  "inputs": [
    "software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_API/imsmanifest.xml"
  ],
  "outputs": [
    "screenshot_start.png",
    "screenshot_end.png",
    "summary_log.txt",
    "notes.md"
  ],
  "result": {
    "status": "pass|fail|warn|blocked",
    "summary": "Short run outcome summary"
  },
  "variance_notes": "Differences from historical baseline expectations"
}
```

### Required notes.md Sections
1. Run summary
1. Step-by-step actions performed
1. Observed behavior
1. Variance from expected baseline behavior
1. Follow-up actions

### Evidence Index File
Create [evidence index CSV](evidence/phase1/index/phase1_evidence_index.csv) with columns:
- run_id
- backlog_item
- group
- case_id
- date_utc
- runner
- baseline_class
- result_status
- evidence_path
- notes_path

### Quality Gates
1. A run folder is invalid if metadata.json is missing.
1. A run folder is invalid if notes.md is missing.
1. Runtime run folders are invalid if either screenshot_start.png or screenshot_end.png is missing.
1. Any blocked run must include a variance note and a remediation owner.

### Mapping to Existing Deliverables
1. Matrix case IDs originate from [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md).
1. Bootstrap evidence format aligns with [phase1_p1-02_bootstrap_evidence_2026-10-08.md](phase1_p1-02_bootstrap_evidence_2026-10-08.md).
1. Runtime group folders map to LMS, SCO, CP, MAN, and optional CHK matrix groups.

### Exit Criteria for P1-07
1. QA and PM approve directory layout and naming model.
1. metadata.json field set is approved.
1. Index CSV column set is approved.
1. At least one bootstrap run and one runtime run are stored using this schema.

### Version History
- v1.0 (2026-10-08): Initial artifact schema and storage model for Phase 1 baseline evidence.
